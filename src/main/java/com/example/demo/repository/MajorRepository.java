package com.example.demo.repository;

import com.example.demo.entity.Major;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MajorRepository extends CrudRepository<Major,Integer> {
    Major findById(int id);
    List<Major> findAll();
}
