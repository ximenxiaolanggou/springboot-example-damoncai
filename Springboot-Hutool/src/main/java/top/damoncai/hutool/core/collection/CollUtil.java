package top.damoncai.hutool.core.collection;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 * @author zhishun.cai
 * @date 2021/2/25 16:11
 */

public class CollUtil {

    public static<T> List<T> newArrayList(T... t) {
        if(null == t) return null;
        return list(false,t);
    }

    public static<T> List<T> list(boolean isLinked,T... t) {
        List<T> list = isLinked ? new LinkedList<T>() : new ArrayList<T>();
        Collections.addAll(list,t);
        return list;
    }

    public static<T> String join(Iterable<T> iterable,CharSequence sep) {
        if(null == iterable) return "";
        StringBuffer sb = new StringBuffer();
        Iterator<T> iterator = iterable.iterator();
        boolean first = true;
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (first) {
                first = false;
                sb.append(t);
            }else{
                sb.append(sep);
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
