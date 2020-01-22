package com.example.demoapi.Controller;

import com.example.demoapi.DTO.CourseDTO;
import com.example.demoapi.DTO.UserCourseDTO;
import com.example.demoapi.DTO.UserCourseFilterRequest;
import com.example.demoapi.DTO.UserDTO;
import com.example.demoapi.EnrollUserRequest;
import com.example.demoapi.Entity.User;
import com.example.demoapi.Response.CommonResponse;
import com.example.demoapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public CommonResponse< List<UserDTO>> getAllUsers() {
        return new CommonResponse<>(userService.getAllUsers());
    }

    @PostMapping("")
    public CommonResponse<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new CommonResponse<>(userService.createUser(userDTO));
    }

    @PostMapping("/apply")
    public CommonResponse<String> enrollUserToCourse(@RequestBody EnrollUserRequest request){
        String data = userService.enrollUser(request.getCourseId(),request.getUserId());
        return new CommonResponse<>(data);
    }
    @GetMapping("/{id}")
    public CommonResponse<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
        return new CommonResponse<>(userService.getUser(userId));
    }

    @PutMapping("/{id}")
    public CommonResponse<String> updateUser(@RequestBody User user, Long id) {
        String data = userService.updateUser(user, id);
        return new CommonResponse<>(data);
    }

    @DeleteMapping("/{id}")
    public CommonResponse<String> deleteUser(@PathVariable Long id) {
        return new CommonResponse<>(userService.deleteUser(id));
    }

    @GetMapping("/search")
    public CommonResponse <List<UserDTO>> findUser(@RequestParam(value = "name") String name) {
        return new CommonResponse<>(userService.userSearch(name));
    }

    @GetMapping("{id}/course")
    public CommonResponse<List<CourseDTO>> getCoursesForUserId(@PathVariable(value = "id") Long id){
       return new CommonResponse<>(userService.getCoursesForUserId(id));
    }

    @PostMapping("/courses/filter")
    public Object getUserAndCourseForFilter(@RequestBody UserCourseFilterRequest request){
        //return new CommonResponse<>(userService.getFilteredData(request));
        return userService.getFilteredData(request);
    }

}
