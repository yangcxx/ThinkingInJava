package cn.yangcx.array16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/12 7:15
 */
public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<>();
        // ls[1] = new ArrayList<Integer>();

        // todo 数组是协变的；集合不是
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
        // List<String> strings1 = new ArrayList<>();
        // List<Object> objects3 = objects2;

        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }

        List<BerylliumSphere> berylliumSpheres = new ArrayList<>();
        List<Object> objects1 = new ArrayList<>();
        objects1.add(new Object());
        objects1.add(new BerylliumSphere());

    }

}
