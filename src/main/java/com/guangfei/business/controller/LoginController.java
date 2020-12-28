package com.guangfei.business.controller;

import com.guangfei.business.service.LoginService;
import com.guangfei.handle.Result;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController{

    @Autowired
    private LoginService loginService;

    @PostMapping("/updatePwd")
    public Result updatePwd(String username, String oldPwd,String newPwd){
        /*
        * 使用BCryptPasswordEncoder之前先引入spring-boot-starter-security的依赖，如果不想看到SpringSecurity
        * 自带的登录弹框，1.可以在启动类的@SpringBootApplication上排除SpringSecurity的自动配置类  2.可以
        * 在yml文件中配置security.basic.enabled=false
        * */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String oldPwdEncode = bCryptPasswordEncoder.encode(oldPwd);
        System.out.println("~~~~~~~~~~~~~~~"+oldPwdEncode);

        String pwd=loginService.getPwdByUsername(username);

        boolean flag = bCryptPasswordEncoder.matches(oldPwd, pwd);
        if (flag){
            log.info("updatePwd{()}密码校验成功");
            return Result.ok().message("修改密码成功");
        }
        log.error("updatePwd{()}密码校验失败");
        return Result.error().message("修改密码失败");
    }

    @PostMapping("/testMd5")
    public Result testMd5(String testStr,String salt) {
        String str1 = Md5Crypt.apr1Crypt(testStr.getBytes(), salt);
        System.out.println("~~~~~~~~~~~~~~~"+str1);
        String str2 = Md5Crypt.apr1Crypt(testStr, salt);
        System.out.println("~~~~~~~~~~~~~~~"+str2);
        return Result.ok().message("I am back");
    }

    @PostMapping("/getCurrentTime")
    public void getCurrentTime() {
        long timeMillis = System.currentTimeMillis();
        //timeMillis的值为1604990099896
        System.out.println("~~~~~~~~~~~~~~~~~"+timeMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
        String format1 = dateFormat.format(timeMillis);
        System.out.println("~~~~~~~~~~~~~~~~~format1="+format1);

        Date date = new Date();
        System.out.println("~~~~~~~~~~~~~~~~~date="+date);
        String format2 = dateFormat.format(date);
        System.out.println("~~~~~~~~~~~~~~~~~format2="+format2);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("~~~~~~~~~~~~~~~~~now1="+now1);
        ZoneId zoneId =ZoneId.of("Asia/Shanghai");
        System.out.println("~~~~~~~~~~~~~~~~~now2="+zoneId);
    }
}
