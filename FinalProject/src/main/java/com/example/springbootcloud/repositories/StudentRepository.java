package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
