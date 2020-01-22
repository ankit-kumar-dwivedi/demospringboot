package com.example.demoapi.Repository;

import com.example.demoapi.Entity.Course;
import com.example.demoapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByNameContaining(String name);

   // @Query(value = "select c.* from courses c inner join user_courses uc where uc.id = :id")
    @Query("select distinct c from Course c join c.users join_table where join_table.id = :id")
    List<Course> getAllCoursesById(@Param("id") Long id);
}
