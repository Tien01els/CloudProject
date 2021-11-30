package com.example.springbootcloud.model.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
public class MemberDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String gender;
    private Long age;
    private String phone;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String fullname) {
        this.firstname = fullname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
