package com.example.springbootcloud.controller;

import com.example.springbootcloud.model.dto.AccountDTO;
import com.example.springbootcloud.model.dto.StudentDTO;
import com.example.springbootcloud.model.dto.TeacherDTO;
import com.example.springbootcloud.service.account.AccountService;
import com.example.springbootcloud.service.student.StudentService;
import com.example.springbootcloud.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/teacher")
    public ResponseEntity<?> createAccountTeacher(@RequestBody AccountDTO req){
        AccountDTO result = accountService.createAccount(req);
        TeacherDTO teacherDTO = teacherService.createTeacher(result.getAccount_id());
        return ResponseEntity.ok(teacherDTO);
    }

    @PostMapping("/student")
    public ResponseEntity<?> createAccountStudent(@RequestBody AccountDTO req){
        AccountDTO result = accountService.createAccount(req);
        StudentDTO studentDTO = studentService.createStudent(result.getAccount_id());
        return ResponseEntity.ok(studentDTO);
    }
}
