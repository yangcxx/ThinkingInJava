package cn.yangcx.demo;

/**
 * TODO<br/>
 * Date: 2020/6/15 6:58 <br/>
 *
 * @author YANGCX
 */
public class HelloDate {

    public static void main(String[] args) {
        //System.out.println("Hello,it's: ");
        //System.out.println(new Date());
        //System.out.println();
        System.getProperties().list(System.out);
        System.out.println(
                System.getProperties().getProperty("java.library.path")
        );
    }

}
