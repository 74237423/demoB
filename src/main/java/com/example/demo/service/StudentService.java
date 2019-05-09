package com.example.demo.service;

import com.example.demo.entity.ChooseCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.ChooseCourseRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ChooseCourseRepository chooseCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    public Student findStudentById(int id){
        return studentRepository.findById(id);
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    //登录
    public boolean login(int id,String ps) {
        Student student = findStudentById(id);
        return !student.equals(null) && student.getPassword().equals(ps);
    }

    //选课
    public void select(int stu_id,int co_id){
        ChooseCourse chooseCourse = new ChooseCourse();
        chooseCourse.setCourse(courseRepository.findById(co_id));
        chooseCourse.setStudent(findStudentById(stu_id));
        chooseCourse.setDatetime(getNowTime());

        chooseCourseRepository.save(chooseCourse);
    }

    //退课
    public void cancel(int stu_id,int co_id){
        chooseCourseRepository.deleteByStudentAndCourse(findStudentById(stu_id),courseRepository.findById(co_id));
    }

    private Timestamp getNowTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
