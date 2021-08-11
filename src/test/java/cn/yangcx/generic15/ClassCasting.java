package cn.yangcx.generic15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/10 6:39
 */
public class ClassCasting<W, T> {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> cast = (List<Widget>) in.readObject();
    }

    public void f1(List<W> wList) {
        System.out.println("f1");
    }

    public void f2(List<T> tList) {
        System.out.println("f2");
    }

}
