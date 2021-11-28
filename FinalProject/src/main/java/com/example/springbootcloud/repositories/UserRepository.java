package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
