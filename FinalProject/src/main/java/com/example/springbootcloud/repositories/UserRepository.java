package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
