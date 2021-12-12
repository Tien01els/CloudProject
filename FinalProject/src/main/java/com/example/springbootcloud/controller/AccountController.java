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

    //Tạo tài khoản dưới role = teacher
    @PostMapping("/teacher")
    public ResponseEntity<?> createAccountTeacher(@RequestBody AccountDTO req){
        AccountDTO result = accountService.createAccount(req);
        TeacherDTO teacherDTO = teacherService.createTeacher(result.getAccount_id());
        return ResponseEntity.ok(teacherDTO);
    }

    //Tạo tài khoản dưới role = Student
    @PostMapping("/student")
    public ResponseEntity<?> createAccountStudent(@RequestBody AccountDTO req){
        AccountDTO result = accountService.createAccount(req);
        StudentDTO studentDTO = studentService.createStudent(result.getAccount_id());
        return ResponseEntity.ok(studentDTO);
    }

    //Lấy thông tin account = accid ra cho user xem
    @GetMapping("/{accid}")
    public ResponseEntity<?> getInfoAccount(@PathVariable("accid") Long id){
        AccountDTO result = accountService.getAccountById(id);
        return ResponseEntity.ok(result);
    }

    //Kiểm tra xem old password đúng hay không
    @PostMapping("/checkOldPass")
    public ResponseEntity<?> checkOldPassword(@RequestBody AccountDTO accountDTO){
        HashMap<String, String> result = new HashMap<>();
        result.put("key", accountService.checkOldPassword(accountDTO));
        return ResponseEntity.ok(result);
    }

    //Update tài khoản theo account id
    @PutMapping("/update")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO req){
        accountService.updateAccountById(req);
        HashMap<String, String> result = new HashMap<>();
        result.put("key", "Success");
        return ResponseEntity.ok(result);
    }

    //Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody AccountDTO req){
        HashMap<String, String> check = accountService.checkLogin(req);
        return ResponseEntity.ok(check);
    }


    //Global ID
    @GetMapping("/getGlobalId")
    public ResponseEntity<?> getGlobalid(){
        HashMap<String, String> result = new HashMap<String, String>();
        if(GlobalVariable.IDaccount != -1L && GlobalVariable.IDuser != -1L && GlobalVariable.UserRole != null){
            result.put("key", "Success");
            result.put("key_accid", Long.toString(GlobalVariable.IDaccount));
            result.put("key_userid", Long.toString(GlobalVariable.IDuser));
            result.put("key_userrole", GlobalVariable.UserRole);
        }else {
            result.put("key", "Fail");
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("deleteGlobalId")
    public ResponseEntity<?> deleteGlobalId(){
        GlobalVariable.IDaccount = -1L;
        GlobalVariable.IDuser = -1L;
        GlobalVariable.UserRole = null;
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("key", "Success");
        return ResponseEntity.ok(result);
    }
}
