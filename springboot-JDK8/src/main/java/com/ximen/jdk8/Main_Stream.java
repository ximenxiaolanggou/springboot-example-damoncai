package com.ximen.jdk8;

import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhishun.cai
 * @date 2020/7/13 23:07
 * @note
 */
public class Main_Stream {

    private static List<Person> persons = new ArrayList<>();
    private static List<String> strs =null;

    static {
        persons.add(new Person("张三",30));
        persons.add(new Person("李四",40));
        persons.add(new Person("王五",50));
        persons.add(new Person("钱六",60));
        persons.add(new Person("钱六",50));
        persons.add(new Person("钱六",60));

        strs = Arrays.asList("aa","bb","cc","dd");
    }

    public static void main(String[] args) {
        System.out.println("==================== filter ====================");
        filter();
        System.out.println("==================== limit ====================");
        limit();
        System.out.println("==================== skip ====================");
        skip();
        System.out.println("==================== distinct ====================");
        distinct();
        System.out.println("==================== map ====================");
        map();
        System.out.println("==================== flatMap ====================");
        flatMap();
        System.out.println("==================== sorted ====================");
        sorted();
        System.out.println("==================== allMatch ====================");
        allMatch();
        System.out.println("==================== anyMatch ====================");
        anyMatch();
        System.out.println("==================== noneMatch ====================");
        noneMatch();
        System.out.println("==================== findFirst ====================");
        findFirst();
        System.out.println("==================== findAny ====================");
        findAny();
        System.out.println("==================== count ====================");
        count();
        System.out.println("==================== max ====================");
        max();
        System.out.println("==================== min ====================");
        min();
        System.out.println("==================== reduce ====================");
        reduce();
        System.out.println("==================== collect1 ====================");
        collect1();
        System.out.println("==================== collect2 ====================");
        collect2();
        System.out.println("==================== collect3 ====================");
        collect3();
    }

    //创建流的方式
    public static void createStream(){
        //1.可以通过Collection系列集合提供的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream() 获取数组流
        Person[] persons = new Person[10];
        Stream<Person> stream2 = Arrays.stream(persons);

        //3.通过Stream类中的静态方法 of()
        Stream<String> stream3 = Stream.of("A","B","C");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0,x -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

    //========================================= 筛选和切片 =========================================
    /**
     * filter
     */
    public static void filter(){
        persons.stream().filter(person -> person.getAge() > 40).forEach(System.out::println);
    }

    /**
     * limit
     */
    public static void limit(){
        persons.stream().filter(person -> person.getAge() > 40).limit(1).forEach(System.out::println);
    }

    /**
     * limit
     */
    public static void skip(){
        persons.stream().filter(person -> person.getAge() > 40).skip(1).limit(1).forEach(System.out::println);
    }

    /**
     * distinct(通过生成hashcode和equals去重)
     */
    public static void distinct(){
        persons.stream().filter(person -> person.getAge() > 40).distinct().forEach(System.out::println);
    }

    //========================================= 映射 =========================================

    /**
     * map； 接收；lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成新的元素
     */
    public static void map(){
        strs.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        Stream<Stream<Character>> stream = strs.stream().map(Main_Stream::strToChar);
        stream.forEach(sm -> {
            sm.forEach(System.out::println);
        });
    }

    /**
     * faltMap：接收一个函数作为参数，将流中的每个值都转换为另一个流，然后将所有的流串成一个流
     */
    public static void flatMap(){
        strs.stream().flatMap(Main_Stream::strToChar).forEach(System.out::println);
    }

    public static Stream<Character> strToChar(String str){
        List<Character> characters = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characters.add(character);
        }
        return characters.stream();
    }

    //========================================= 排序 =========================================

    /**
     * 排序
     * sorted() - 自然排序(Comparable)
     * sorted() - (Comparator com) -> 定制排序(Comparator)
     */
    public static void sorted(){
        strs.stream().sorted().forEach(System.out::println);

        persons.stream().sorted(((o1, o2) -> {
            return o1.getAge() > o2.getAge() ? -1 : 1;
        })).forEach(System.out::println);
    }

    //========================================= 查找和匹配 =========================================

    /**
     * allMatch - 检查是否匹配所有元素
     */
    public static void allMatch(){
        boolean b = persons.stream().allMatch(person -> person.getAge() > 60);
        System.out.println(b);
    }

    /**
     * anyMatch - 检查是否至少匹配一个元素
     */
    public static void anyMatch(){
        boolean b = persons.stream().anyMatch(person -> person.getAge() > 60);
        System.out.println(b);
    }

    /**
     * noneMatch - 检查是否没有匹配所有元素
     */
    public static void noneMatch(){
        boolean b = persons.stream().noneMatch(person -> person.getAge() > 60);
        System.out.println(b);
    }

    /**
     * findFirst - 返回第一个元素
     */
    public static void findFirst(){
        Optional<Person> b = persons.stream().findFirst();
        System.out.println(b.get());
    }

    /**
     * findAny - 返回当前流中任意元素
     */
    public static void findAny(){
        Optional<Person> b = persons.stream().findAny();
        System.out.println(b.get());
    }

    /**
     * count - 返回当前流中元素个数
     */
    public static void count(){
        long count = persons.stream().count();
        System.out.println(count);
    }

    /**
     * max - 返回最大值
     */
    public static void max(){
        Optional<Person> person = persons.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        System.out.println(person);
    }

    /**
     * min - 返回最小值
     */
    public static void min(){
        Optional<Integer> min = persons.stream().map(Person::getAge).min(Integer::compareTo);
        System.out.println(min.get());
    }

    //========================================= 归约 =========================================

    /**
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 可以将流中的数据反复结合起来，得到一个值
     */
    public static void reduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("sum : " + sum);

        Optional<Integer> sumOpt = list.stream().reduce((x, y) -> x + y);
        Optional<Integer> sumOpt2 = list.stream().reduce(Integer::sum);
        System.out.println("sum : " + sumOpt.get());
    }

    //========================================= 收集 =========================================

    /**
     * 转换成集合
     */
    public static void collect1(){
        //放入list
        List<String> nameList = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("list ：");
        nameList.forEach(System.out::println);

        //放入set
        Set<String> nameSet = persons.stream().map(Person::getName).collect(Collectors.toSet());
        System.out.println("set ：");
        nameSet.forEach(System.out::println);

        //放入LinkedHashSet
        LinkedHashSet<String> linkedHashSet = persons.stream().map(Person::getName).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("linkedHashSet ：");
        linkedHashSet.forEach(System.out::println);
    }

    /**
     * 统计
     */
    public static void collect2(){
       //总数
        Long count = persons.stream().collect(Collectors.counting());
        System.out.println("count ：" + count);

        //平均值
        Double avgAge = persons.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("avgAge : " + avgAge);

        //总和
        Integer sumAge = persons.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println("sumAge : " + sumAge);

        //最大值
        Optional<Person> maxAge = persons.stream().collect(Collectors.maxBy((a, b) -> Integer.compare(a.getAge(), b.getAge())));
        System.out.println("maxAge : " + maxAge.get());

        //最小值
        Optional<Integer> minAge = persons.stream().map(Person::getAge).collect(Collectors.minBy(Integer::compare));
        System.out.println("minAge : " + minAge.get());
    }

    /**
     * 分组和分区
     */
    public static void collect3(){
        //单级分组
        Map<String, List<Person>> groupName = persons.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println("groupName ：" + groupName);

        //多级分组
        Map<String, Map<Integer, List<Person>>> groupNameAge = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getAge)));
        System.out.println("groupNameAge : " + groupNameAge);

        Map<String, Map<String, List<Person>>> groupNameAge2 = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(e -> {
            if(e.getAge() >= 60){
                return "休息";
            }else{
                return "加班";
            }
        })));
        System.out.println("groupNameAge2 : " + groupNameAge2);

        //分区
        Map<Boolean, List<Person>> partition = persons.stream().collect(Collectors.partitioningBy(e -> e.getAge() >= 60));
        System.out.println("partition : " + partition);

        //最牛逼方法(集大成者)

        DoubleSummaryStatistics statistics = persons.stream().collect(Collectors.summarizingDouble(Person::getAge));
        System.out.println("max ：" + statistics.getMax());
        System.out.println("min " +statistics.getMin());
        System.out.println("avg" + statistics.getAverage());
        System.out.println("count " +statistics.getCount());
        System.out.println("sum " +statistics.getSum());

        //join
        String join = persons.stream().map(Person::getName).collect(Collectors.joining(",", "==Start==", "==End=="));
        System.out.println("join " + join);
    }
}
