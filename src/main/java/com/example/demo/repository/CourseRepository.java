package com.example.demo.repository;

import com.example.demo.entity.BCourse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<BCourse,Integer> {
    BCourse findById(String id);
    List<BCourse> findAll();
}
