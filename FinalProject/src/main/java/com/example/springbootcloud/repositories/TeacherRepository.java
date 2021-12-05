package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
