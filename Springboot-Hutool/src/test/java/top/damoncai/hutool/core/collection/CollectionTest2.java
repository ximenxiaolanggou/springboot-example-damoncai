package top.damoncai.hutool.core.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/2/25 15:31
 */

public class CollectionTest2 {

    @Test
    public void test() {
        String[] col= new String[]{"a","b","c","d","e"};
        List<String> colList = CollUtil.newArrayList(col);
        System.out.println(colList);

        String str = CollUtil.join(colList, "#"); //str -> a#b#c#d#e
        System.out.println(str);
    }
}
