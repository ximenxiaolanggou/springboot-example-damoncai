package com.ximen.jdk8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhishun.cai
 * @date 2020/7/12 16:58
 * @note
 *
 * Java8 四大核心函数接口
 *
 * Consumer<T> : 消费型接口
 *          void accept(T t)
 *
 * Supplier<T> : 供给型接口
 *          T get()
 *
 * Function(T,R) : 函数型接口
 *          R apply(T t):
 *
 * Predicate<T>  : 断言型接口
 *          boolean test(T t)  
 */
public class Main_Lambda {
    public static void main(String[] args) {
        add(1, 2, (a, b) -> a + b);

        doConsumer(t -> {
            System.out.println(t);
        });

        doFunction("damon",t -> {
            return t.length();
        });

        doPredicate(0,t -> {
            return t > 0;
        });
    }

    public static int add(int a, int b, Operation operation){
        int sum = operation.add(a, b);
        System.out.println(sum);
        return sum;
    }

    public static void doConsumer(Consumer consumer){
        consumer.accept("damon");
    }

    public static void doFunction(String name,Function<String,Integer> function){
        Integer len = function.apply(name);
        System.out.println("res ==> " + len);
    }

    /**
     * 将满足条件的字符串放到集合中
     */
    public static void doPredicate(int num , Predicate<Integer> predicate){
        if(predicate.test(num)){
            System.out.println("正数");
        }else{
            System.out.println("非正数");
        }
    }
}
