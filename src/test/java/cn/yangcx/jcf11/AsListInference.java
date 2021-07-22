package cn.yangcx.jcf11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/6/29 7:48
 */
public class AsListInference {

    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

        ArrayList<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy());

        // todo 泛型指定
        // List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }

}

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
