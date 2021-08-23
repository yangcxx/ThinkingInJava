package cn.yangcx.io18;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * @author YANGCX
 * @date 2021/8/23 7:55
 */
public class AvailableCharSets {

    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        for (String csName : charSets.keySet()) {
            printnb(csName);
            Iterator<String> aliases = charSets.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                printnb(": ");
            }
            while (aliases.hasNext()) {
                printnb(aliases.next());
                if (aliases.hasNext()) {
                    printnb(", ");
                }
            }
            print();
        }
    }

}
