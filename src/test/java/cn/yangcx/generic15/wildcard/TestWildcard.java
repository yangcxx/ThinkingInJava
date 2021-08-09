// package cn.yangcx.generic15;
//
// /**
//  * @author YANGCX
//  * @date 2021/8/4 7:04
//  */
// public class TestWildcard {
//
//     public static void main(String[] args) {
//         Plate<Fruit> p = new Plate<>(new Apple());
//     }
//
// }
//
// class Plate<T> {
//     private T item;
//
//     public Plate(T item) {
//         this.item = item;
//     }
//
//     public void set(T item) {
//         this.item = item;
//     }
//
//     public T get() {
//         return this.item;
//     }
// }
//
// class Food {
// }
//
// class Fruit extends Food {
// }
//
// class Meat extends Food {
// }
//
// class Apple extends Fruit {
// }
//
// class Banana extends Fruit {
// }
//
// class Port extends Meat {
// }
//
// class Beef extends Meat {
// }
//
// class RedApple extends Apple {
// }
//
// class GreenApple extends Apple {
// }
