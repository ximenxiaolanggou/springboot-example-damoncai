package top.damoncai.hutool.core.clone;


/**
 * @author zhishun.cai
 * @date 2021/2/25 11:00
 */
public class Person implements Cloneable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
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

    public Person() {
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


    public Person clone() {
        try {
            /**
             * 调用Object的clone方法
             *
             * 我们知道，JDK中的Cloneable接口只是一个空接口，并没有定义成员，
             * 它存在的意义仅仅是指明一个类的实例化对象支持位复制（就是对象克隆），
             * 如果不实现这个类，调用对象的clone()方法就会抛出CloneNotSupportedException异常。
             * 而且，因为clone()方法在Object对象中，返回值也是Object对象，因此克隆后我们需要自己强转下类型。
             */
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
