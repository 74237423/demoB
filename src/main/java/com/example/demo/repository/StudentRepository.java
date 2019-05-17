package com.example.demo.repository;

import com.example.demo.entity.BStudent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<BStudent,Integer> {

    BStudent findById(String id);
    List<BStudent> findAll();
}
