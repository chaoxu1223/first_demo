package com.guangfei.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(description = "学生")
public class Student implements Serializable{

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")

    private String name;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("女友名")
    @JsonProperty("girl_friend_name")
    private String girlFriendName;



    /**
     * controller层的@RequestBody注解仅可以将Json类型转化成Java对象，不能接收Key/value键值对
     * 如要接收键值对，请勿使用@RequestBody注解
     *
     * 实体类字段上的@JsonFormat用于转化Json格式数据中的时间
     * 实体类字段上的@DateTimeFormat用于转化key/value键值对中的时间
     */
    @ApiModelProperty("生日")
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date birthday;

    @ApiModelProperty("号码")
    private String phone;

    @ApiModelProperty("班级")
    private Integer classId;

    @ApiModelProperty("老师们")
    private List<Teacher> teacherList;

    @ApiModelProperty("所属年级")
    private Grade grade;

}
