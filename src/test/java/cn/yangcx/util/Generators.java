package cn.yangcx.util;

import cn.yangcx.generic15.Fibonacci;
import cn.yangcx.generic15.coffee.Coffee;
import cn.yangcx.generic15.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author YANGCX
 * @date 2021/7/26 21:55
 */
public class Generators {

    // 泛型用于Generator
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
        Collection<Integer> fNumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer fNumber : fNumbers) {
            System.out.print(fNumber + " ");
        }
    }

}
