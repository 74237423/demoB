package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course findCourseById(int id){
        return courseRepository.findById(id);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

}
