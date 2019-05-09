package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Major;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;

	@Test
	public void contextLoads() {
		Student student = studentService.findStudentById(2);
		Assert.assertEquals(null,student);

	}
	@Test
	public void test2(){
		Student student = studentService.findStudentById(1);
		Assert.assertEquals("软件工程",student.getMajor().getName());
	}

	@Test
	public void test3(){
		Student student = new Student();
		Major major = new Major();
		major.setId(1);
		student.setName("modd");
		student.setPassword("22");
		student.setMajor(major);
		studentRepository.save(student);
	}
}
