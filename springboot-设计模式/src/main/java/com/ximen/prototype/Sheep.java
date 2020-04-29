package com.ximen.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2020/4/16 20:37
 * @note
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sheep implements Cloneable {
    private String name;

    private Integer age;

    private String color;


    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
