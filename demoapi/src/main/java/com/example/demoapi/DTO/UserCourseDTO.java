package com.example.demoapi.DTO;

import java.util.List;

public class UserCourseDTO {
    List<UserDTO> userDTOList;
    List<CourseDTO> courseDTOList;

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }

    public List<CourseDTO> getCourseDTOList() {
        return courseDTOList;
    }

    public void setCourseDTOList(List<CourseDTO> courseDTOList) {
        this.courseDTOList = courseDTOList;
    }
}
