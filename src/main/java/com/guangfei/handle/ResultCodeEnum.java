package com.guangfei.handle;


import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(true,20000,"成功"),
    UNKNOWN_ERROR(false,20001,"未知的错误"),
    PARAM_ERROR(false,20002,"参数错误"),
    NULL_POINT(false,20003,"空指针异常"),
    HTTP_CLIENT_ERROR(false,20004,"客户端连接异常"),
    INDEX_OUTOF_BOUNDS_ERROR(false,20005,"数组越界异常");

    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
