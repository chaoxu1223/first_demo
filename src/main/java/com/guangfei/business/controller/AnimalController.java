package com.guangfei.business.controller;

import com.guangfei.business.entity.Animal;
import com.guangfei.handle.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @PostMapping("/saveAnimal")
    public Result saveAnimal(@RequestBody @Validated Animal animal){
       /*List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> map = new HashMap();
        fieldErrors.stream().forEach(e->{
            String defaultMessage = e.getDefaultMessage();
            String field = e.getField();
            map.put(field,defaultMessage);
        });
        if(map.size()>0){
            return Result.ok().message("出现了错误信息").data("map",map);
        }*/
        return Result.ok().message("成功了");
    }

}
