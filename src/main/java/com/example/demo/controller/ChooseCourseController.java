package com.example.demo.controller;

import com.example.demo.entity.BCourse;
import com.example.demo.service.ChooseCourseService;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import com.example.demo.util.CourseIsSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChooseCourseController  {
    @Autowired
    private ChooseCourseService chooseCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/courses",method = GET)
    @ResponseBody
    public List<CourseIsSelect> goSelectPage(@RequestParam("stu_id") String stu_id){
        List<BCourse> courses = courseService.findAllCourses();//所有课程

        List<CourseIsSelect> courseIsSelect= new ArrayList<>();
        for (int i=0;i<courses.size();i++){
            String co_id = courses.get(i).getId();
            boolean isSelect = chooseCourseService.isChoose(stu_id,co_id);
            courseIsSelect.add(new CourseIsSelect(courses.get(i),isSelect));
        }
        return courseIsSelect;//跳转到选课界面
    }
    @RequestMapping(value = "/select",method = GET)
    @ResponseBody
    public boolean selectCourse(@RequestParam("course_id") String course_id ,@RequestParam("stu_id") String stu_id ){

        return studentService.select(stu_id,course_id);//添加选课记录;
    }

}
