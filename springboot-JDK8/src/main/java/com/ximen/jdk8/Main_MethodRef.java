package com.ximen.jdk8;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author zhishun.cai
 * @date 2020/7/13 20:06
 * @note
 */
public class Main_MethodRef {

    public static void main(String[] args) {
        fun1();
        fun2();
        fun3();
        fun4();
        fun5();
    }

    public static void fun1(){
        Person person = new Person("damon",12);
        Supplier<Integer> con = person::getAge;
        Integer age = con.get();
        System.out.println(age);
    }

    public static void fun2(){
       Comparator<Integer> comparable = (x,y) -> Integer.compare(x,y);
        int res = comparable.compare(1, 2);
        Function<Person,Integer> function = Person::getAge;
        BiFunction<Person,Person,Boolean> biFunction = Person::gg;
        BiPredicate<Person,String> predicate = Person::haha;
        predicate.test(new Person("hehe",12),"damon");
        System.out.println(res);
        Comparator<Integer> comparable2 = Integer::compareTo;
    }

    public static void fun3(){
        BiPredicate<String,String> predicate = (x,y) -> x.equals(y);
        System.out.println(predicate.test("a","a"));

        BiPredicate<String,String> predicate2 = String::equals;
    }

    public static void fun4(){
        Supplier<Person> supplier = () -> new Person();
        Person person = supplier.get();
        BiFunction<String,Integer,Person> biFunction = Person::new;
        Person damon = biFunction.apply("damon", 12);
        System.out.println(damon.getAge());
    }

    public static void fun5(){
        Function<Integer,Integer[]> function = x -> new Integer[]{x};
        Integer[] apply = function.apply(1);
        System.out.println(Arrays.toString(apply));

        Function<Integer,Integer[]> function2 = Integer[]::new;
        Integer[] apply2 = function.apply(2);
        System.out.println(Arrays.toString(apply2));
    }

}
