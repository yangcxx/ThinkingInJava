package cn.yangcx.typeinfo14.factory;

/**
 * @author YANGCX
 * @date 2021/7/22 10:09
 */
public interface Factory<T> {

    /**
     * 这就是一个工厂方法
     *
     * @return 返回创建的实体
     */
    T create();

}
