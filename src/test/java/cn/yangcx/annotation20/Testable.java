package cn.yangcx.annotation20;


/**
 * @author YANGCX
 * @date 2021/9/2 7:41
 */
public class Testable {

    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }

}
