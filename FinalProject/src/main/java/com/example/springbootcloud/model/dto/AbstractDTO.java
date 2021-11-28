package com.example.springbootcloud.model.dto;

import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {
    private Long id;
    private String fullname;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private List<T> listResult = new ArrayList<>();

    public List<T> getListResult() { return listResult; }
    public void setListResult(List<T> listResult) { this.listResult = listResult; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
