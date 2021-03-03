package top.damoncai.hutool.core.clone;

/**
 * @author zhishun.cai
 * @date 2021/2/25 11:04
 * @note
 */

/**
 * 调用Object的clone方法
 *
 * 我们知道，JDK中的Cloneable接口只是一个空接口，并没有定义成员，
 * 它存在的意义仅仅是指明一个类的实例化对象支持位复制（就是对象克隆），
 * 如果不实现这个类，调用对象的clone()方法就会抛出CloneNotSupportedException异常。
 * 而且，因为clone()方法在Object对象中，返回值也是Object对象，因此克隆后我们需要自己强转下类型。
 */
public interface Cloneable<T> extends java.lang.Cloneable {
    T clone();
}
