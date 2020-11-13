package com.guangfei.business.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Party implements Serializable {
    private String id;
    private String leaderName;
    private String partyName;
    private List<Teacher> teacherList;
}
