package com.example.demo;

import com.example.demo.entity.ChooseCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.Major;
import com.example.demo.entity.Student;
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

	@Test
	public void test5(){
		boolean ii= studentService.login(1,"123");
		Assert.assertEquals(true,ii);
	}
	@Test
	public void test6(){
		boolean ii= studentService.login(1,"1234");
		Assert.assertEquals(false,ii);
	}

	@Test
    public void test8(){
	    
	   boolean n=  chooseCourseService.isChoose(5,3);
	   Assert.assertEquals(true,n);
        boolean n1=  chooseCourseService.isChoose(2,3);
        Assert.assertEquals(false,n1);
        boolean n2=  chooseCourseService.isChoose(1,1);
        Assert.assertEquals(true,n2);
    }
}
