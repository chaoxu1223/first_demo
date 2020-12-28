package com.guangfei.business.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Party implements Serializable {
    private Integer id;
    private String leaderName;
    private String partyName;

    public Party() {
    }

    public Party(Integer id, String partyName, String leaderName) {
        this.id = id;
        this.leaderName = leaderName;
        this.partyName = partyName;
    }
}
