package cn.yangcx.initialization_and_clean05.objects;

/**
 * TODO<br/>
 * Date: 2020/6/15 6:57 <br/>
 *
 * @author YANGCX
 */
public class ObjectsTest {

    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly);

        Incrementable incrementable = new Incrementable();
        incrementable.increment();
        //Incrementable.increment();
    }

}
