package com.example.springbootcloud.controller;

import com.example.springbootcloud.global.GlobalVariable;
import com.example.springbootcloud.model.dto.AccountDTO;
import com.example.springbootcloud.model.dto.StudentDTO;
import com.example.springbootcloud.model.dto.TeacherDTO;
import com.example.springbootcloud.service.account.AccountService;
import com.example.springbootcloud.service.student.StudentService;
import com.example.springbootcloud.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody AccountDTO req){
        HashMap<String, String> check = accountService.checkLogin(req);
        return ResponseEntity.ok(check);
    }

    @GetMapping("/getAccid")
    public ResponseEntity<?> getAccid(){
        HashMap<String, String> result = new HashMap<String, String>();
        if(GlobalVariable.IDaccount != -1L){
            result.put("key", Long.toString(GlobalVariable.IDaccount));
        }else {
            result.put("key", "Fail");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getUserid")
    public ResponseEntity<?> getUserid(){
        HashMap<String, String> result = new HashMap<String, String>();
        if(GlobalVariable.IDuser != -1L){
            result.put("key", Long.toString(GlobalVariable.IDuser));
        }else{
            result.put("key", "Fail");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getUserrole")
    public ResponseEntity<?> getUserrole(){
        HashMap<String, String> result = new HashMap<String, String>();
        if(GlobalVariable.UserRole != null){
            result.put("key", Long.toString(GlobalVariable.IDuser));
        }else{
            result.put("key", "Fail");
        }
        return ResponseEntity.ok(result);
    }
}
