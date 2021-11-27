package com.example.springbootcloud.service;

import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public Iterable<User>  getListUser();
    //        public User getUserById(int id);
    public UserDto createUser(UserDto user);
//    public void updateUserById(User user);
//    public void deleteUserById(int id);
}
