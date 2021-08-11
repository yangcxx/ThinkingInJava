package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/9 21:53
 */
public class MultipleInterfaceVariants {
}

interface Payable<T> {

}

class Employee2 implements Payable<Employee2> {

}

// class Hourly extends Employee2 implements Payable<Hourly> {
// todo 泛型擦除后，Payable<Employee2>和Payable<Hourly>简化为完全相同的类，即重复两次实现相同的接口
// }


