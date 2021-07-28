package cn.yangcx.generic15.coffee;

import cn.yangcx.util.Generator;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/26 7:32
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private final Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static final Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator cg = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(cg.next());
        }
        System.out.println();
        // todo 实现了 java.lang.Iterable
        CoffeeGenerator coffees = new CoffeeGenerator(5);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
