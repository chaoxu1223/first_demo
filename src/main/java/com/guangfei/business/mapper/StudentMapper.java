package com.guangfei.business.mapper;

import com.guangfei.business.entity.Student;
import com.guangfei.business.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    public List<Student> findAllStudent();

    int addStudent(Student student);

    void updateStudent(Student student);

    Student findTeachersOfStudent(@Param("id") Integer id);

    Student findStudentById(@Param("id") Integer id);

    void addStudentAndTeacher(@Param("studentId")Integer studentId, @Param("teacherId")Integer teacherId);

}
