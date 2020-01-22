package com.example.demoapi.DTO;

import java.util.List;

public class UserCourseFilterRequest {
    List<Long> userIds;
    List<Long> courseIds;
    List<String> userNames;
    List<String> courseTitles;
    List<FeesCondition> feesCond;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
    }

    public List<String> getCourseTitles() {
        return courseTitles;
    }

    public void setCourseTitles(List<String> courseTitles) {
        this.courseTitles = courseTitles;
    }

    public List<FeesCondition> getFeesCond() {
        return feesCond;
    }

    public void setFeesCond(List<FeesCondition> feesCond) {
        this.feesCond = feesCond;
    }
}
