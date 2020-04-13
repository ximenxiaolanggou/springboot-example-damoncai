package com.ximen.thread.zconsumerproduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:56
 * @note
 */
public class Container {
    /**
     * 容器也想法当于锁
     */
    public static List<String> container = new ArrayList<String>();
}
