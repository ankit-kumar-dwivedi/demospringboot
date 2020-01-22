package com.example.demoapi.Repository;

import com.example.demoapi.Entity.Course;
import com.example.demoapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository <Course,Long> {
    List<Course> findByTitleContaining(String title);

    @Query("select c.users from Course c where c.title = :t")
    List<User> getAllUserByCourseName(@Param("t") String name);
//
//    @Query("select distinct u from User u where u.courses.course_id = :t")
//    List<User> getAllUserByCourseName(@Param("t") Long  id);
}
