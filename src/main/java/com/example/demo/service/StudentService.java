package com.example.demo.service;

import com.example.demo.entity.BChooseCourse;
import com.example.demo.entity.BCourse;
import com.example.demo.entity.BStudent;
import com.example.demo.repository.ChooseCourseRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ChooseCourseRepository chooseCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    public BStudent findStudentById(String id){
        return studentRepository.findById(id);
    }
    public List<BStudent> findAllStudents(){
        return studentRepository.findAll();
    }

    //登录
    public boolean login(String id,String ps) {
        BStudent student = findStudentById(id);
        if (student==null)
            return false;
        return student.getPassword().equals(ps);
    }
    private String createOrdercheckId(){
        String id="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        //获取随机数
        int random=(int) ((Math.random()+1)*1000);
        id=temp+random;
        return id;

    }
    //选课
    public boolean select(String stu_id,String co_id){
        BChooseCourse chooseCourse = new BChooseCourse();
        chooseCourse.setId(createOrdercheckId());
        chooseCourse.setCourse(courseRepository.findById(co_id));
        chooseCourse.setStudent(findStudentById(stu_id));

        chooseCourseRepository.save(chooseCourse);
        List<BChooseCourse> chooseCourses = chooseCourseRepository.findByStudentAndCourse(findStudentById(stu_id),courseRepository.findById(co_id));
        return chooseCourses.size() != 0;
    }

    //退课
    public boolean cancel(String stu_id,String co_id){
        chooseCourseRepository.deleteByStudentAndCourse(findStudentById(stu_id),courseRepository.findById(co_id));
        List<BChooseCourse> chooseCourses = chooseCourseRepository.findByStudentAndCourse(findStudentById(stu_id),courseRepository.findById(co_id));
        return chooseCourses.size()==0;
    }

}
