package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.ChooseCourseService;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {
    @Autowired
    private ChooseCourseService chooseCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/coursepage",method = GET)
    public String toCourse(){
        return "/course-page.html";
    }

    @RequestMapping(value = "/home",method = GET)
    @ResponseBody
    public List<BCourse> toHome(@RequestParam("stu_id") String stu_id){

        List<BChooseCourse> chooseCourseList = chooseCourseService.findAllChooseByStu(stu_id);
        List<BCourse> hasChosenCourses = new ArrayList<>();
        for (int i=0;i<chooseCourseList.size();i++){
            BCourse course = chooseCourseList.get(i).getCourse();
            hasChosenCourses.add(course);
        }

        return hasChosenCourses;//跳转到系统主页，主页显示显示已选课程列表
    }
    @RequestMapping(value = "/cancle",method = GET)
    @ResponseBody
    public boolean dropCourse(@RequestParam("course_id") String course_id ,@RequestParam("stu_id") String stu_id ){
        return studentService.cancel(stu_id,course_id);//删除选课记录;
    }
}
