package com.example.redisproj.dto;

import lombok.*;

import java.io.Serializable;


public class UserRequestDto implements Serializable {
    Long id;
    private String fname;

    private String lname;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public void setFname(String fname){
        this.fname=fname;
    }

    public void setLname(String lname){
        this.lname=lname;
    }


    // getters and setters
}
