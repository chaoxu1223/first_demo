package com.guangfei.business.service;

import com.guangfei.business.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public String getPwdByUsername(String username) {
        return loginMapper.getPwdByUsername(username);
    }
}
