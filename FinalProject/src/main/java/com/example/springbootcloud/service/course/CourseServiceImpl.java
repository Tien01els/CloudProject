package com.example.springbootcloud.service.course;

import com.example.springbootcloud.converter.CourseConverter;
import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.entity.Teacher;
import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public List<CourseDTO> selectCourseByTeacherId(Long teacher_id){
        List<Course> courses = courseRepository.findCourseByTeacher_id(teacher_id);
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
        for (Course cours : courses) {
            coursesDTO.add(courseConverter.toDTO(cours));
        }
        return coursesDTO;
    }

    @Override
    public void deleteCourse(CourseDTO courseDTO) {
        courseRepository.deleteCourseByCourse_idAndTeacher_id(courseDTO.getCourse_id(), courseDTO.getTeacher_id());
    }

    @Override
    public ArrayList<HashMap<String, String>> getListCourse(){
        List<Object[]> list = courseRepository.findAllCourseAndHaveTeacherName();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        for(int i = 0; i < list.size(); ++i) {
            HashMap<String, String> map = new HashMap<>();
            Course course = (Course) list.get(i)[0];
            map.put("course_id", Long.toString(course.getCourse_id()));
            map.put("name", course.getName());

            Teacher teacher = (Teacher) list.get(i)[1];
            map.put("teacher_name", teacher.getFirstname() + " " + teacher.getLastname());

            result.add(map);
        }
        return result;
    }
}
