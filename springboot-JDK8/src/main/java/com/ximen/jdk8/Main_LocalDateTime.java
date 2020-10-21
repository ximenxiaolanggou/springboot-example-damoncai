package com.ximen.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author zhishun.cai
 * @date 2020/7/16 9:58
 * @note
 */
public class Main_LocalDateTime {
    public static void main(String[] args) {
        System.out.println("============================ LocalDateTime ============================");
        localDateTime();

        System.out.println("============================ Instant ============================");
        instant();

        System.out.println("============================ Duration ============================");
        duration();

        System.out.println("============================ Period ============================");
        period();

        System.out.println("============================ TemporalAdjuster ============================");
        temporalAdjuster();

        System.out.println("============================ DateTimeFormatter ============================");
        dateTimeFormatter();

        System.out.println("============================ Zoned ============================");
        zoned();

    }
    public static void localDateTime(){
        //获取当前时间
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        //获取指定时间
        LocalDateTime ldt2 = LocalDateTime.of(2020,05,17,13,11,11);
        System.out.println(ldt2);

        //加 plus
        LocalDateTime ldt3 = ldt1.plusWeeks(1L);
        System.out.println(ldt3);

        //减 minus
        LocalDateTime ldt4 = ldt1.minusDays(7L);
        System.out.println(ldt4);

        //获取年、月、日、时、分、秒
        System.out.println(ldt1.getYear());
        System.out.println(ldt1.getMonthValue());
        System.out.println(ldt1.getDayOfMonth());
        System.out.println(ldt1.getHour());
        System.out.println(ldt1.getMinute());
        System.out.println(ldt1.getSecond());
    }

    public static void instant(){
        // 默认获取 UTC 时区 (UTC：世界协调时间)
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        //带偏移量的时间日期 (如：UTC + 8)
        OffsetDateTime odt1 = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt1);

        //转换成对应的毫秒值
        long milli1 = ins1.toEpochMilli();
        System.out.println(milli1);

        //构建时间戳
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    //计算两个时间之间的间隔
    public static void duration(){
        //计算两个时间之间的间隔 between
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura1 = Duration.between(ins1, ins2);
        System.out.println(dura1.getSeconds());
        System.out.println(dura1.toMillis());
    }

    //计算两个时间之间的间隔
    public static void period(){
        LocalDate ld1 = LocalDate.of(2016, 9, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);  // ISO 标准
        System.out.println(period.getYears());
        System.out.println(period.toTotalMonths());
    }

    public static void temporalAdjuster(){
        //TemporalAdjusters：时间校正器
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        //指定日期时间中的 年 月 日 ...
        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        //指定时间校正器
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义时间校正器
        LocalDateTime ldt5 = ldt1.with((ta) -> {
            LocalDateTime ldt4 = (LocalDateTime) ta;
            DayOfWeek dow1 = ldt4.getDayOfWeek();
            if (dow1.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow1.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    //格式化时间 / 日期
    public static void dateTimeFormatter(){
        //默认格式化
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        String format = dtf1.format(LocalDateTime.now());
        LocalDateTime ldt1 = LocalDateTime.now();
        String str1 = ldt1.format(dtf1);
        System.out.println(str1);

        //自定义格式化 ofPattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt2 = LocalDateTime.now();
        String str2 = ldt2.format(dtf2);
        System.out.println(str2);

        //解析
        LocalDateTime newDate = LocalDateTime.parse(str1, dtf1);
        LocalDateTime newDate2 = LocalDateTime.parse(str2, dtf2);
        System.out.println(newDate);
        System.out.println(newDate2);
    }

    public static void zoned(){
        //查看支持的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //指定时区
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt1);

        //在已构建好的日期时间上指定时区
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zdt1 = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt1);
    }
}
