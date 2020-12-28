package com.guangfei.business.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangfei.business.entity.Student;
import com.guangfei.business.service.StudentService;
import com.guangfei.handle.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findAllStudent")
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

    @GetMapping("/findAllStudentByPageInfo")
    public Result findAllStudentByPageInfo(PageInfo<Student> page){
        if(page.getPageNum()<=0){
            page.setPageNum(1);
        }
        if(page.getPageSize()<2){
            page.setPageSize(2);
        }
        Page<Student> startPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Student> studentList = studentService.findAllStudent();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList);

        /*PageInfo<Student> studentPageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize()).
                doSelectPageInfo(()-> studentService.findAllStudent()
        );*/
        return Result.ok().message("分页查询成功").data("studentPageInfo",studentPageInfo);
    }

    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student student){
        if(!StringUtils.isEmpty(student) &&
                !StringUtils.isEmpty(student.getTeacherList().get(0))){
            studentService.addStudent(student);
            return Result.ok().message("Im fine,Thankyou");
        }
        return Result.error().message("我感觉很不好");
     }

    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.ok().message("Im fine,Thankyou");
    }

    @GetMapping("/findTeachersOfStudent/{id}")
    public Result findTeachersOfStudent(@PathVariable("id") Integer id){
        Student student=studentService.findTeachersOfStudent(id);
        return Result.ok().message("查出某一学生的所有老师").data("student",student);
    }

    @GetMapping("/findTeachersOfAllStudent")
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
