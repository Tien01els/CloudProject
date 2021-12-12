package com.example.springbootcloud.controller;

import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.service.course.CourseService;
import com.example.springbootcloud.service.score.ScoreService;
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

    @Autowired
    private ScoreService scoreService;

    //Tạo course theo id teacher
    @PostMapping("")
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO req){
        CourseDTO result = courseService.createCourse(req);
        return ResponseEntity.ok(result);
    }

    //Lấy ra danh sách tất cả các course
    @GetMapping("")
    public ResponseEntity<?> getListCourse(){
        ArrayList<HashMap<String, String>> result = courseService.getListCourse("", -1L);
        return ResponseEntity.ok(result);
    }

    //Lấy ra danh sách course mà student đó đăng kí - student
    @GetMapping("/registered/{userid}")
    public ResponseEntity<?> getListCourseRegistered(@PathVariable("userid") Long id){
        ArrayList<HashMap<String, String>> result = courseService.getListCourse("registered", id);
        return ResponseEntity.ok(result);
    }

    //Lấy ra danh sách course của teacher đó
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseByTeacherId(@PathVariable("id") Long teacher_id){
        List<CourseDTO> coursesDTO = courseService.selectCourseByTeacherId(teacher_id);
        return ResponseEntity.ok(coursesDTO);
    }

    //Update khóa học
    @PutMapping("")
    public ResponseEntity<?> updateCourse(@RequestBody CourseDTO req){
        CourseDTO result = courseService.updateCourse(req);
        return ResponseEntity.ok(result);
    }

    //Xóa khóa học
    @DeleteMapping("")
    public ResponseEntity<?> deleteCourse(@RequestBody CourseDTO req){
        scoreService.deleteAllScoreByCourseId(req.getCourse_id());
        courseService.deleteCourse(req);
        HashMap<String, String> result = new HashMap<>();
        result.put("key", "Success");
        return ResponseEntity.ok(result);
    }
}
