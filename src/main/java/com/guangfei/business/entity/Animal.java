package com.guangfei.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal{

    private String id;

    @NotBlank(message = "属性为null or 去掉前后空格后,字符串长度<=0")
    private String name;

    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",message = "手机号码输入错误")
    private String phoneNumber;

    /**
     * 身价
     */
    private String socialStatus;

    @Email
    private String email;
}
