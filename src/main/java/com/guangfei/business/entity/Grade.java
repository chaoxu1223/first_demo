package com.guangfei.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade implements Serializable{
    private Integer id;

    /*年级名称*/
    private String gradeName;

    private Integer teachNum;

    private Integer stuNum;

    /*入学时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;

    /*毕业时间*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

    private List<Student> studentList;
    private List<Teacher> teacherList;
}
