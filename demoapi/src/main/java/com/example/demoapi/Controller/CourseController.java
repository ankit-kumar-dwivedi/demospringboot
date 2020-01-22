package com.example.demoapi.Controller;

import com.example.demoapi.DTO.CourseDTO;
import com.example.demoapi.DTO.UserDTO;
import com.example.demoapi.Entity.Course;
import com.example.demoapi.Response.CommonResponse;
import com.example.demoapi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public CommonResponse<CourseDTO> addCourse(@RequestBody CourseDTO course){
        return  new CommonResponse<>(courseService.create(course));
    }

    @GetMapping("")
    public CommonResponse<List<CourseDTO>> getAllCourses(){
        return new CommonResponse<>(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public CommonResponse<CourseDTO> getCourseById(@PathVariable(value = "id") Long courseId) {
        return new  CommonResponse<>(courseService.getCourse(courseId));
    }

    @PutMapping("/{id}")
    public CommonResponse<Object> updateCourse(@RequestBody CourseDTO courseDTO,@PathVariable Long id) {
        return new CommonResponse<>(courseService.updateCourse(courseDTO, id));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<String> deleteCourse(@PathVariable Long id) {
        return new CommonResponse<>(courseService.deleteCourse(id));
    }

    @GetMapping("/name")
    public CommonResponse<List<UserDTO>> getUsersForCourseId(@RequestParam(value = "name") String name){
        return new CommonResponse<>(courseService.getUserForCourseName(name.toLowerCase()));
    }


}
