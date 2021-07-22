package cn.yangcx.interface09.test;

/**
 * 接口支持多重继承 -- <strong>只能有一个具体实现</strong>
 *
 * @author YANGCX
 * @date 2021/6/8 7:46
 */
public class Test5 {
}

interface i1 {

}

interface i11 extends i1 {

}

interface i12 extends i1 {

}

interface i2 extends i11, i12 {

}
