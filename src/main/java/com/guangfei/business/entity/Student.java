package com.guangfei.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{

    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    @JsonProperty("girl_friend_name")
    private String girlFriendName;

    /**
     * controller层的@RequestBody注解仅可以将Json类型转化成Java对象，不能接收Key/value键值对
     * 如要接收键值对，请勿使用@RequestBody注解
     *
     * 实体类字段上的@JsonFormat用于转化Json格式数据中的时间
     * 实体类字段上的@DateTimeFormat用于转化key/value键值对中的时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date birthday;

    private String phone;

    private Integer classId;

    private List<Teacher> teacherList;

    private Grade grade;

}
