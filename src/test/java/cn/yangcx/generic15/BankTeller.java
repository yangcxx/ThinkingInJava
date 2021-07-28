package cn.yangcx.generic15;

import cn.yangcx.util.Generator;
import cn.yangcx.util.Generators;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/7/27 7:24
 */
public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer customer : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), customer);
        }
    }

}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    // todo 每次执行都返回同一个 Generator
    public static Generator<Teller> generator = Teller::new;

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    // todo 每次执行都会返回一个新的 Generator
    public static Generator<Customer> generator() {
        return Customer::new;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
