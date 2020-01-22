package com.example.demoapi.DTO;

import com.example.demoapi.Entity.User;

import java.util.Date;

public class UserDTO {

    public UserDTO() {
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.createdTime = user.getCreatedTime();
    }
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    private Date createdTime;


}
