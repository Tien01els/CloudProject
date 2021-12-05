package com.example.springbootcloud.service.course;

import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

//    @Autowired
//    private CourseService ;

//    @Override
//    public CourseDTO createCourse(Lo)
}
