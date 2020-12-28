package com.guangfei.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassUnit {

    private Integer id;

    private String className;

    private Integer classStuNum;

    private Integer masterId;
}
