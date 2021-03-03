package top.damoncai.hutool.core.date;

import cn.hutool.core.date.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhishun.cai
 * @date 2021/2/25 15:31
 */

public class DateUtil {

    public static DateTime date() {
        return new DateTime();
    }

    public static DateTime date(Calendar calendar) {
        return new DateTime(calendar);
    }

    public static DateTime date(long date) {
        return new DateTime(date);
    }

    public static DateTime parse(String dateStr,String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return new DateTime();
    }
}
