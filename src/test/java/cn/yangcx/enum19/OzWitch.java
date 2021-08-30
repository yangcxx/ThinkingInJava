package cn.yangcx.enum19;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/30 21:26
 */
public enum OzWitch {

    WEST("Miss Gulch, aka the Wicked Witch of the West"),

    NORTH("Glinda, the Good Witch of the North"),

    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),

    SOUTH("Good by inference, but missing");

    private final String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}
