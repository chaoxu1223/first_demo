package com.guangfei.business.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("学生们")
    private List<Student> studentList;

    @ApiModelProperty("所属政党")
    private Party party;
}
