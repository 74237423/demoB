package com.example.demo.service;

import com.example.demo.entity.Major;
import com.example.demo.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public Major findMajorById(int id){
        return majorRepository.findById(id);
    }
}
