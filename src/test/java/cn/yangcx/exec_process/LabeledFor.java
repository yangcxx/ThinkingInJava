package cn.yangcx.exec_process;

/**
 * 标签<br/>
 * Date: 2020/6/16 7:39 <br/>
 *
 * @author YANGCX
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i = 0;
        outer:
        for (; ; ) {
            inner:
            for (; i < 10;i++ ) {
                System.out.println("i= " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    //break outer;
                    return;
                }
                for (int i1 = 0; i1 < 5; i1++) {
                    if (i1 == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }

}
