package com.example.springbootcloud.converter;

import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setFullname(dto.getFullname());
        user.setGender(dto.getGender());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setActions(dto.getActions());
        return user;
    }
    public UserDto toDTO(User entity) {
        UserDto dto = new UserDto();
        dto.setFullname(entity.getFullname());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setActions(entity.getActions());
        return dto;
    }
}
