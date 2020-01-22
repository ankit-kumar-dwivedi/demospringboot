package com.example.demoapi.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course  implements Serializable {

    @Id
    private long course_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "fee", nullable = false)
    private Long fee;

    @CreatedDate
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp", updatable = false)
    private Date createdTime;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();


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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
