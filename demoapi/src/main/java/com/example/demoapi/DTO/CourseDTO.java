package com.example.demoapi.DTO;


import com.example.demoapi.Entity.Course;

import java.util.Date;

public class CourseDTO {

    public CourseDTO() {
    }

    public CourseDTO(Course course) {
        this.course_id = course.getCourse_id();
        this.title = course.getTitle();
        this.fee = course.getFee();
        this.createdTime = course.getCreatedTime();
    }

    private long course_id;

    private String title;

    private Long fee;

    private Date createdTime;

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
