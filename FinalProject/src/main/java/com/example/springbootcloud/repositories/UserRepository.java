package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
