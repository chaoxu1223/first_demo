package com.guangfei.business.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangfei.config.Person;
import com.guangfei.business.entity.Student;
import com.guangfei.business.service.StudentService;
import com.guangfei.handle.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@Api(tags="学生接口")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private  Person person;

    @Value("${guang.fei}")
    private String str;

    @GetMapping("/findAllStudent")
    @ApiOperation(value = "查询所有学生")
    public Result findAllStudent(int pageNum,int pageSize){
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<2){
            pageSize=2;
        }
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentService.findAllStudent();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList);
        return Result.ok().data("StudentPageInfo",studentPageInfo);
    }

    @PostMapping("/addStudent")
    @ApiOperation(value = "新增学生")
    public Result addStudent(@RequestBody Student student){
        if(!StringUtils.isEmpty(student) &&
                !StringUtils.isEmpty(student.getTeacherList().get(0))){
            studentService.addStudent(student);
            return Result.ok().message("Im fine,Thankyou");
        }
        return Result.error().message("我感觉很不好");
     }

    @PostMapping("/updateStudent")
    @ApiOperation(value = "修改某一学生信息")
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.ok().message("Im fine,Thankyou");
    }

    @GetMapping("/findTeachersOfStudent/{id}")
    @ApiOperation(value = "查出某一学生的所属年级与其所有老师")
    public Result findTeachersOfStudent(@PathVariable("id") Integer id){
        Student student=studentService.findTeachersOfStudent(id);
        return Result.ok().message("查出某一学生的所有老师").data("student",student);
    }

    @GetMapping("/findTeachersOfAllStudent")
    @ApiOperation(value = "查出所有学生的所有老师")
    public Result findTeachersOfAllStudent(@RequestParam("id") Integer[] ids){
        ArrayList<Student> lists = new ArrayList<Student>();

        if(ids!=null && ids.length>0){
            for (Integer id : ids) {
                Student student=studentService.findTeachersOfStudent(id);
                lists.add(student);
            }
        }
        return Result.ok().message("查出所有学生的所有老师").data("lists",lists);
    }
}
