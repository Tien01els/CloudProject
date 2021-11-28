package com.example.springbootcloud.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Component
public class UserDTO extends AbstractDTO<UserDTO>{
    private Long id;
    private String fullname;
    private String gender;
    private int age;
    private String email;
    private String phone;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFullname() {return fullname;}

    public void setFullname(String fullname) {this.fullname = fullname;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

}