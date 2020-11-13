package com.guangfei.business.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassUnit {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("班级名称")
    private String className;

    @ApiModelProperty("班级学生数")
    private Integer classStuNum;

    @ApiModelProperty("班主任,与Teacher表关联")
    private Integer masterId;
}
