package cn.yangcx.exec_process;

/**
 * For 循环中支持逗号操作符（控制表达式的初始化和步长部分）<br/>
 * Date: 2020/6/16 7:21 <br/>
 *
 * @author YANGCX
 */
public class CommaOperator {

    public static void main(String[] args) {

        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i= " + i + " ,j= " + j);
        }

    }

}
