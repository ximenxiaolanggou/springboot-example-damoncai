package top.damoncai.hutool.core.clone;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @date 2021/2/25 10:59
 */

public class CloneTest {
    
    @Test
    public void cloneTest() {
        Person person = new Person("西门",12);
        Person person_clone = person.clone();
        System.out.println("person:" + person);
        System.out.println("person_clone:" + person_clone);
        System.out.println(person == person_clone);
    }

    @Test
    public void cloneSupportTest() {
        Person person = new Person("西门",12);
        Person person_clone = person.clone();
        System.out.println("person:" + person);
        System.out.println("person_clone:" + person_clone);
        System.out.println(person == person_clone);
    }

    @Test
    public void deepCloneTest() {
        Person person = new Person("西门",12);
        Person person_clone = ObjectUtil.cloneByStream(person);
    }
}
