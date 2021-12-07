package com.example.springbootcloud.service.course;

import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.model.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);
    Iterable<Course> getListCourse();
    CourseDTO updateCourse(CourseDTO courseDTO);
    void deleteCourse(CourseDTO courseDTO);
    List<CourseDTO> selectCourseByTeacherId(Long teacher_id);
}
