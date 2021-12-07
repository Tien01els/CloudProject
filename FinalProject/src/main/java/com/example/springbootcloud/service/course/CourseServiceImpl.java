package com.example.springbootcloud.service.course;

import com.example.springbootcloud.converter.CourseConverter;
import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseConverter courseConverter;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = courseConverter.toEntity(courseDTO);
        course = courseRepository.save(course);
        return courseConverter.toDTO(course);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO){
        Course existingCourse = courseRepository.findCourseByCourse_idAndTeacher_id(courseDTO.getCourse_id(), courseDTO.getTeacher_id());
        assert existingCourse != null;
        Course course = courseConverter.toExistingEntity(existingCourse, courseDTO);
        course = courseRepository.save(course);
        return courseConverter.toDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {

    }

//    @Autowired
//    private CourseService ;

//    @Override
//    public CourseDTO createCourse(Lo)
}
