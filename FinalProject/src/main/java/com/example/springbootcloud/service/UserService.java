package com.example.springbootcloud.service;

import com.example.springbootcloud.entity.UserEntity;
import com.example.springbootcloud.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<UserEntity> getListUser();
    UserDTO createUser(UserDTO userDto);
    UserDTO updateUser(UserDTO userDto);
    void deleteUser(UserDTO userDto);

    //    public void updateUserById(User user);
    //    public void deleteUserById(int id);
}
