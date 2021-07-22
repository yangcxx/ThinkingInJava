package cn.yangcx.string13;

import java.util.Formatter;

/**
 * @author YANGCX
 * @date 2021/7/16 7:48
 */
public class Receipt {

    private double total = 0;
    private final Formatter format = new Formatter(System.out);

    public void printTitle() {
        format.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        format.format("%-15s %5s %10s\n", "----", "----", "----");
    }

    public void print(String name, int qty, double price) {
        format.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        format.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        format.format("%-15s %5s %10s\n", "", "", "----");
        format.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt r = new Receipt();
        r.printTitle();
        r.print("Jack's Magic Beans", 4, 4.25);
        r.print("Princess Peas", 3, 5.1);
        r.print("Three Bears Porridge", 1, 14.25);
        r.printTotal();
    }

}
