package com.ximen.jdk8;

import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author zhishun.cai
 * @date 2020/7/15 19:30
 * @note
 */
public class Main_Fock {
    private static Long start = 0L;
    private static Long end = 1000000000L;
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        OptionalLong sum = LongStream
                .range(start, end)
                .parallel() //变成并行流
                .reduce(Long::sum);
        System.out.println(sum.getAsLong());
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        IntStream.range(0,10).filter(x -> x%2 == 0).forEach(System.out::println);
    }
}
