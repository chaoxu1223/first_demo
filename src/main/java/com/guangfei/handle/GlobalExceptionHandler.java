package com.guangfei.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static HashMap<String,String> map=new HashMap();

    /**-------- 通用异常处理方法 --------**/
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        // 通用异常结果打印到日志
        log.error("出现错误",e.getMessage(),e.getClass());
        return Result.error();
    }

    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    public Result error(NullPointerException e) {
        e.printStackTrace();
        return Result.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public Result error(HttpClientErrorException e) {
        e.printStackTrace();
        return Result.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result error(IndexOutOfBoundsException e) {
        e.printStackTrace();
        return Result.setResult(ResultCodeEnum.INDEX_OUTOF_BOUNDS_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result error(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.stream().forEach(s->{
            String field = s.getField();
            String defaultMessage = s.getDefaultMessage();
            map.put(field,defaultMessage);
        });
            return Result.ok().message("出现了错误信息").data("map",map);
    }
}
