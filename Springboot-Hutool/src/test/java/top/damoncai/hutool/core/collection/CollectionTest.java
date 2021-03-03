package top.damoncai.hutool.core.collection;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/2/25 15:31
 */

public class CollectionTest {

    @Test
    public void test() {
        String[] col= new String[]{"a","b","c","d","e"};
        List<String> colList = CollUtil.newArrayList(col);

        CollUtil.sub(colList,1,2);

        String str = CollUtil.join(colList, null); //str -> a#b#c#d#e
        System.out.println(str);
    }
}
