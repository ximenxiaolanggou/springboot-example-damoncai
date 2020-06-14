package com.ximen._1.singleton;

/**
 * @author zhishun.cai
 * @date 2020/6/13 16:50
 * @note
 */
public enum  Singleton4 {

    /**
     * 不仅可以解决线程同步，还可以防止反序列化
     */
    INSTANCE;
}
