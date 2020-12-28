package com.guangfei.business.entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    private Integer id;

    private String name;

    private List<Student> studentList;

    private Party party;
}
