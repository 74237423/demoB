package com.example.demo.service;

import com.example.demo.entity.ChooseCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
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

    public ChooseCourse findChooseById(int id){
        return chooseCourseRepository.findById(id);
    }
    public List<ChooseCourse> findAllChoose(){
        return chooseCourseRepository.findAll();
    }
    public List<ChooseCourse> findAllChooseByStu(int stu_id){
        Student student = studentRepository.findById(stu_id);
        return chooseCourseRepository.findAllByStudent(student);
    }

    public List<ChooseCourse> findAllChooseByCourse(int co_id){
        Course course = courseRepository.findById(co_id);
        return chooseCourseRepository.findAllByCourse(course);
    }

    public boolean isChoose(int stu_id,int co_id){
        Student student = studentRepository.findById(stu_id);
        Course course = courseRepository.findById(co_id);
        return chooseCourseRepository.findByStudentAndCourse(student, course) != null;
    }
}
