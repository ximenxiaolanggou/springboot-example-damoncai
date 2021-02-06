package com.ximen.jdk8;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2020/11/18 10:23
 * @note
 */

public class Ts {
    public static void main(String[] args) {
        System.out.println(Ts.handleCycleTimestamp("2020-11-12T18:00"));
    }
    private static String handleCycleTimestamp(String starttime) {
        if(starttime == null || starttime.trim() == "") {
            return "";
        }
        String[] dateAndTime = starttime.split("T");
        String YMD = Arrays.stream(dateAndTime[0].split("-")).reduce("", (first, second) -> first + second);
        String HMS = Arrays.stream(dateAndTime[1].split(":")).reduce("", (first, second) -> first + second);
        if(HMS.length() == 4) {
            StringBuffer sb = new StringBuffer(HMS);
            sb.append("00");
            HMS = sb.toString();
        }
        return YMD + "T" + HMS;
    }
}
