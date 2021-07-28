package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/28 21:41
 */
public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        System.out.println(factory.t);

        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
            System.err.println(fi.t);
        } catch (Exception e) {
            System.err.println("ClassAsFactory<Integer> failed");
        }
    }
}

class Employee {
}

class ClassAsFactory<T> {

    T t;

    public ClassAsFactory(Class<T> type) {
        try {
            // todo 创建类的实例
            //  泛型 T，无法尝试使用 new T() 创建新对象（1、泛型擦除后类型未知；2、编译器无法确认是否具有无参构造）
            //  解决方式：传递一个工厂对象（最常用的就是 Class 对象）
            //  这种方式非常不推荐使用
            t = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
