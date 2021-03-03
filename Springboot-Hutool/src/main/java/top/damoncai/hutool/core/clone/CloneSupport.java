package top.damoncai.hutool.core.clone;

/**
 * @author zhishun.cai
 * @date 2021/2/25 11:17
 */

import cn.hutool.core.clone.CloneRuntimeException;

/**
 * 和Cloneable接口相比：
 * 1.Cloneable中定义了泛型，规范了返回的数据类型
 * 2.将Cloneable接口改为CloneSupport<T>实现类，并重写Object中的clone方法，根据泛型返回相应的对象
 * 3.这样就避免了每个需要克隆的对象重写clone方法
 *
 * TODO JAVA单继承特性，使用该类要求不能有其他实现类
 * @param <T>
 */
public class CloneSupport<T> implements java.lang.Cloneable {

    /**
     * 重写Object中clone方法，将返回类型Object细化成泛型对象
     *
     * @return T 泛型
     * @throws CloneNotSupportedException
     */
    @Override
    protected T clone() throws CloneNotSupportedException {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new CloneRuntimeException(var2);
        }
    }
}
