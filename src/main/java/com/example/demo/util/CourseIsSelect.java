package com.example.demo.util;

import com.example.demo.entity.BCourse;

public class CourseIsSelect {
    private BCourse course;

    public BCourse getCourse() {
        return course;
    }

    public void setCourse(BCourse course) {
        this.course = course;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    private boolean isSelect;
    public CourseIsSelect(BCourse course,boolean isSelect){
        this.course=course;
        this.isSelect=isSelect;
    }

}
