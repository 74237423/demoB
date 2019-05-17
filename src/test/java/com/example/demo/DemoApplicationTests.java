package com.example.demo;

import com.example.demo.entity.*;

import com.example.demo.repository.ChooseCourseRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ChooseCourseService;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	private ChooseCourseRepository chooseCourseRepository;
	@Autowired
    private ChooseCourseService chooseCourseService;
	@Test
	public void contextLoads() {
		BStudent student = studentService.findStudentById("3");
		Assert.assertEquals(null,student);

	}




}
