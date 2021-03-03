package top.damoncai.hutool.core.clone;


/**
 * @author zhishun.cai
 * @date 2021/2/25 11:00
 */
public class PersonSupport extends CloneSupport<PersonSupport> {
    private String name;
    private Integer age;

    public PersonSupport(String name, Integer age) {
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

    public PersonSupport() {
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
