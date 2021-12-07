package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Account;
import com.example.springbootcloud.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query("SELECT u FROM course u WHERE u.course_id = ?1 and u.teacher_id = ?2")
    Course findCourseByCourse_idAndTeacher_id(Long course_id, Long teacher_id);

    @Query("DELETE FROM course u WHERE u.course_id = ?1 and u.teacher_id = ?2")
    void deleteCourseByCourse_idAndTeacher_id(Long course_id, Long teacher_id);

    @Query("SELECT u FROM course u WHERE u.teacher_id = ?1")
    List<Course> findCourseByTeacher_id(Long teacher_id);
}
