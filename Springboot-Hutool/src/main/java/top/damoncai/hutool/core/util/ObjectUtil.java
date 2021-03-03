package top.damoncai.hutool.core.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author zhishun.cai
 * @date 2021/2/25 11:38
 */

public class ObjectUtil<T> {

    /**
     * TODO 深克隆
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> T cloneByStream(T t) throws IOException {
        if(!(t instanceof Serializable)) {
            return null;
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(""));
        return t;
    }
}
