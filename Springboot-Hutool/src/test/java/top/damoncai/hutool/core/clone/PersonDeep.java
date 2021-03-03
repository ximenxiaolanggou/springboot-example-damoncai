package top.damoncai.hutool.core.clone;


import java.io.Serializable;

/**
 * @author zhishun.cai
 * @date 2021/2/25 11:00
 */
public class PersonDeep implements Serializable {
    private String name;
    private Integer age;

    public PersonDeep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public PersonDeep() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
