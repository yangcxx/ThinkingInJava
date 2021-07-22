package cn.yangcx.reusing07;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author YANGCX
 * @date 2021/5/29 8:37
 */
@Getter
@ToString
@AllArgsConstructor
public class ProtectedParent {

    private String name;

    // cxy protected 成员可以子类（extends|implements）访问
    protected void changeName(String name) {
        this.name = name;
    }

}
