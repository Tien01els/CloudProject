package com.example.springbootcloud.service.user;

import com.example.springbootcloud.converter.UserConverter;
import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDTO;
import com.example.springbootcloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userConverter.toEntity(userDTO);
        user = userRepository.save(user);
        return userConverter.toDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).orElse(null);
        assert existingUser != null;
        User user = userConverter.toExistingEntity(existingUser, userDTO);
        user = userRepository.save(user);
        return userConverter.toDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getListUser() {
        return userRepository.findAll();
    }
}
