package com.damoncai.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
/**
 * MybatisPlus会默认使用实体类的类名到数据库中找对应的表
 * 可以在yml中设置统一表开头
 */
//@TableName(value = "tbl_employee")
public class Employee extends Model<Employee> {
    /**
     *@TableId
     *   value:指定表中的主键列名，如果实体属性与列名一致，可以省略不指定。
     *   type:指定主键策略
     */
//    @TableId(value = "id",type = IdType.AUTO) //可以在yml中配置全局主键生成策略
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private String gender;
    private Integer age;
    /**
     * exist:是否为数据库表字段(默认为true)
     */
    @TableField(exist = false)
    private Double money;
}
