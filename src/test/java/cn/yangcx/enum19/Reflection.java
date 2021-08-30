package cn.yangcx.enum19;

import cn.yangcx.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * @author YANGCX
 * @date 2021/8/30 21:42
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyze " + enumClass + " -----");
        print("Interfaces:");
        for (Type type : enumClass.getGenericInterfaces()) {
            print(type);
        }
        print("Base: " + enumClass.getSuperclass());
        print("Methods:");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        exploreMethods.removeAll(enumMethods);
        printnb("Explore.removeAll(Enum): ");
        print(enumMethods);
        // Explore.valueOf("编译器为其新增了一个同名方法");
        // Decompile the code for the enum
        String absolutePath = "D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\enum19\\Reflection.java";
        OSExecute.command("javap " + absolutePath);
    }

}

enum Explore {
    HERE, THERE
}
