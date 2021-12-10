package com.example.springbootcloud.controller;

import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO req){
        CourseDTO result = courseService.createCourse(req);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<?> getListCourse(){
        ArrayList<HashMap<String, String>> result = courseService.getListCourse();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseByTeacherId(@PathVariable("id") Long teacher_id){
        List<CourseDTO> coursesDTO = courseService.selectCourseByTeacherId(teacher_id);
        return ResponseEntity.ok(coursesDTO);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCourse(@RequestBody CourseDTO req){
        CourseDTO result = courseService.updateCourse(req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("")
    public void deleteCourse(@RequestBody CourseDTO req){
        courseService.deleteCourse(req);
    }
}
