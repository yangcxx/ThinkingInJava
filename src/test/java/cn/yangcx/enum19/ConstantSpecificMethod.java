package cn.yangcx.enum19;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author YANGCX
 * @date 2021/8/31 7:07
 */
public enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }

}

