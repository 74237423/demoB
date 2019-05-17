package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.ChooseCourseRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChooseCourseService {
    @Autowired
    private ChooseCourseRepository chooseCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public BChooseCourse findChooseById(int id){
        return chooseCourseRepository.findById(id);
    }
    public List<BChooseCourse> findAllChoose(){
        return chooseCourseRepository.findAll();
    }
    public List<BChooseCourse> findAllChooseByStu(String stu_id){
        BStudent student = studentRepository.findById(stu_id);
        return chooseCourseRepository.findAllByStudent(student);
    }

    public List<BChooseCourse> findAllChooseByCourse(String co_id){
        BCourse course = courseRepository.findById(co_id);
        return chooseCourseRepository.findAllByCourse(course);
    }

    public boolean isChoose(String stu_id,String co_id){
        BStudent student = studentRepository.findById(stu_id);
        BCourse course = courseRepository.findById(co_id);
        List<BChooseCourse>chooseCourses = chooseCourseRepository.findByStudentAndCourse(student, course);
        return chooseCourses.size()!=0;
    }
}
