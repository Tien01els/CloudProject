package com.example.springbootcloud.service.user;

import com.example.springbootcloud.converter.UserConverter;
import com.example.springbootcloud.entity.UserEntity;
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
        UserEntity userEntity = userConverter.toEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity existingUser = userRepository.findById(userDTO.getId()).orElse(null);
        assert existingUser != null;
        UserEntity userEntity = userConverter.toExistingEntity(existingUser, userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserEntity> getListUser() {
        return userRepository.findAll();
    }
}
