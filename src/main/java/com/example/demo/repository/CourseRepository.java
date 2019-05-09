package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    Course findById(int id);
    List<Course> findAll();
}
