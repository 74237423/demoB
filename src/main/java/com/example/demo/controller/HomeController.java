package com.example.demo.controller;

import com.example.demo.entity.ChooseCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.ChooseCourseService;
import com.example.demo.service.CourseService;
import com.example.demo.service.MajorService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {
    @Autowired
    private ChooseCourseService chooseCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/home",method = GET)
    public List<Course> toHome(@RequestParam("stu_id") String stu_id){
        int id = Integer.parseInt(stu_id);
        List<ChooseCourse> chooseCourseList = chooseCourseService.findAllChooseByStu(id);
        List<Course> hasChosenCourses = new ArrayList<>();
        for (int i=0;i<chooseCourseList.size();i++){
            Course course = chooseCourseList.get(i).getCourse();
            hasChosenCourses.add(course);
        }

        return hasChosenCourses;//跳转到系统主页，主页显示显示已选课程列表
    }
    @RequestMapping(value = "/cancle",method = POST)
    public boolean dropCourse(@RequestParam("course_id") String course_id ,@RequestParam("stu_id") String stu_id ){
        int student_id = Integer.parseInt(stu_id);
        return studentService.cancel(student_id,Integer.parseInt(course_id));//删除选课记录;
    }
}
