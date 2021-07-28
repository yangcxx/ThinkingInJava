package cn.yangcx.generic15;

import cn.yangcx.util.Generator;
import cn.yangcx.util.Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * todo 虽然嵌套了很多层，但通过泛型却不容易产生异常
 *
 * @author YANGCX
 * @date 2021/7/27 7:45
 */
public class Store extends ArrayList<Aisle> {

    private static final long serialVersionUID = -6513053342146969483L;
    private final List<CheckoutStand> checkouts = new ArrayList<>();
    private final Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p).append("\n");
                }
            }
        }
        return result.toString();
    }
}

class CheckoutStand {
}

class Office {
}

class Aisle extends ArrayList<Shelf> {
    private static final long serialVersionUID = 127671302091795491L;

    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class Shelf extends ArrayList<Product> {

    private static final long serialVersionUID = 545393912624024821L;

    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}


class Product {
    private final int id;
    private final String desc;
    private double price;

    public Product(int id, String desc, double price) {
        this.id = id;
        this.desc = desc;
        this.price = price;
        System.out.println(this);
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        final Random random = new Random(47);

        @Override
        public Product next() {
            return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000) + 0.99);
        }
    };

    @Override
    public String toString() {
        return id + ": " + desc + ", price: $" + price;
    }
}
