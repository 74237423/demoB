package com.example.demo.util;

import com.example.demo.entity.Course;

public class CourseIsSelect {
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    private boolean isSelect;
    public CourseIsSelect(Course course,boolean isSelect){
        this.course=course;
        this.isSelect=isSelect;
    }

}
