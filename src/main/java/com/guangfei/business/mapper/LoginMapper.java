package com.guangfei.business.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    public String getPwdByUsername(@Param("username") String username);
}
