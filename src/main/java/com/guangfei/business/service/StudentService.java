package com.guangfei.business.service;

import com.guangfei.business.entity.Teacher;
import com.guangfei.business.mapper.StudentMapper;
import com.guangfei.business.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService{

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
        Integer studentId = student.getId();
        List<Teacher> teacherList = student.getTeacherList();
        for (Teacher teacher : teacherList) {
            Integer teacherId = teacher.getId();
            studentMapper.addStudentAndTeacher(studentId, teacherId);
        }
    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    public Student findTeachersOfStudent(Integer id) {
        return studentMapper.findTeachersOfStudent(id);
    }

    public Student findStudentById(Integer id) {
        return studentMapper.findStudentById(id);
    }

}
