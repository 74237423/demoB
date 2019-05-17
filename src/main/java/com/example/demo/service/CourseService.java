package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public BCourse findCourseById(String id){
        return courseRepository.findById(id);
    }

    public List<BCourse> findAllCourses(){
        return courseRepository.findAll();
    }

}
