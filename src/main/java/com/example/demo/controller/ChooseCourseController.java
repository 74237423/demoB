package com.example.demo.controller;

import com.example.demo.entity.Course;
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

import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ChooseCourseController  {
    @Autowired
    private ChooseCourseService chooseCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/courses",method = GET)
    public String goSelectPage(HttpSession session,ModelMap map){
        List<Course> courses = courseService.findAllCourses();//所有课程
        int stu_id = Integer.parseInt((String) session.getAttribute("stu_id"));
        HashMap<Course,Boolean> coursesIsSelect = new HashMap<>();
        for (int i=0;i<courses.size();i++){
            int co_id = courses.get(i).getId();
            boolean isSelect = chooseCourseService.isChoose(stu_id,co_id);
            coursesIsSelect.put(courses.get(i),isSelect);
        }
        map.addAttribute("coursesIsSelect",coursesIsSelect);//所有课程及其是否已选
        return "/courses.html";//跳转到选课界面
    }
    @RequestMapping(value = "/select",method = POST)
    public String selectCourse(@RequestParam("course_id") String course_id , HttpSession session){
        int stu_id = Integer.parseInt((String) session.getAttribute("stu_id"));
        studentService.select(stu_id,Integer.parseInt(course_id));//添加选课记录
        return "redirect:/courses";
    }

}
