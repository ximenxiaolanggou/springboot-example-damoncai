package com.ximen.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2020/11/6 16:32
 * @note
 */

public class Ted {
    public static void main(String[] args) {
        List<String> targ = Arrays.asList("1", "2", "3");
        List<String> dis = Arrays.asList("1");
        boolean b = targ.stream().anyMatch(item -> {
            System.out.println(item);
            return dis.contains(item);
        });
        System.out.println(b);
    }
}
