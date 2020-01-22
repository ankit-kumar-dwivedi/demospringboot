package com.example.demoapi.Service;

import com.example.demoapi.DTO.CourseDTO;
import com.example.demoapi.DTO.UserDTO;
import com.example.demoapi.Entity.Course;
import com.example.demoapi.Repository.CourseRepository;
import com.example.demoapi.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        return Utils.courseListToDTOList(courseRepository.findAll());
    }

    public CourseDTO create(CourseDTO course) {
        return new CourseDTO(courseRepository.save(Utils.courseDTOtoCourse(course)));
    }

    public String updateCourse(CourseDTO courseDTO, Long id) {
        Optional<Course> updatedCourse = courseRepository.findById(id);
        if(updatedCourse.isPresent())
        {
            courseRepository.save(Utils.courseDTOtoCourse(courseDTO));
            return "Updated Course";
        }
        else {
            return "Course not found";
        }
    }


    public CourseDTO getCourse(Long courseId) {
            Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent())
            return new CourseDTO(course.get());
        else
            return null;
    }

    public String deleteCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            courseRepository.delete(course.get());
            return "Course not found";
        }
        else
            return "Course not found";
    }

    public List<UserDTO> getUserForCourseId(Long courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if(optionalCourse.isPresent()){
            return Utils.useSetToDTOList(optionalCourse.get().getUsers());
        }
        else
            return null;
    }

    public List<UserDTO> getUserForCourseName(String name) {
        return Utils.userListToDTOList(courseRepository.getAllUserByCourseName(name));
    }

}
