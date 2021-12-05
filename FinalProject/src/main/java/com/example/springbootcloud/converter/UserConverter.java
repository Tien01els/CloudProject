package com.example.springbootcloud.converter;

import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setFullname(dto.getFullname());
        user.setGender(dto.getGender());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
    public UserDTO toDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setFullname(entity.getFullname());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    public User toExistingEntity(User entity, UserDTO dto) {
        entity.setFullname(dto.getFullname());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
