package top.damoncai.hutool.core.date;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zhishun.cai
 * @date 2021/2/25 15:31
 */

public class DateTest {

    @Test
    public void test() {
        DateUtil.date(Calendar.getInstance());
        DateUtil.date(System.currentTimeMillis());
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

        date = DateUtil.parse(dateStr);

////结果 2017/03/01
//        String format = DateUtil.format(date, "yyyy/MM/dd");
//
////常用格式的格式化，结果：2017-03-01
//        String formatDate = DateUtil.formatDate(date);
//
////结果：2017-03-01 00:00:00
//        String formatDateTime = DateUtil.formatDateTime(date);
//
////结果：00:00:00
//        String formatTime = DateUtil.formatTime(date);
    }
}
