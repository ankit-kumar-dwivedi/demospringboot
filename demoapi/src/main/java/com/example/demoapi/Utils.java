package com.example.demoapi;

import com.example.demoapi.DTO.CourseDTO;
import com.example.demoapi.DTO.UserDTO;
import com.example.demoapi.Entity.Course;
import com.example.demoapi.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utils {

    private Utils() {
    }

    public static List<UserDTO> userListToDTOList(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user: userList){
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }
    public static List<CourseDTO> courseListToDTOList(List<Course> courseList){
        List<CourseDTO> courseDTOArrayList = new ArrayList<>();
        for(Course course: courseList){
            courseDTOArrayList.add(new CourseDTO(course));
        }
        return courseDTOArrayList;
    }

    public static List<CourseDTO> courseSetToDTOList(Set<Course> courses) {
        List<CourseDTO> courseDTOArrayList = new ArrayList<>();
        for(Course course: courses){
            courseDTOArrayList.add(new CourseDTO(course));
        }
        return courseDTOArrayList;
    }

    public static List<UserDTO> useSetToDTOList(Set<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user: users){
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    public  static User userDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        return user;
    }

    public static Course courseDTOtoCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourse_id(courseDTO.getCourse_id());
        course.setTitle(courseDTO.getTitle());
        course.setFee(courseDTO.getFee());
        return course;
    }
}
