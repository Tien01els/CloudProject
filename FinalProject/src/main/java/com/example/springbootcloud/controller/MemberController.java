package com.example.springbootcloud.controller;

import com.example.springbootcloud.model.dto.MemberDTO;
import com.example.springbootcloud.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody MemberDTO req) {
        MemberDTO result = memberService.createMember(req);
        return ResponseEntity.ok(result);
    }


//    public ResponseEntity<?> checkLogin(@RequestBody MemberDTO req){
//        MemberDTO result = memberService.checkLogin(req);
//        return ResponseEntity.ok(req);
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> checkLogin(@RequestBody MemberDTO req){
//        return ResponseEntity.ok(memberService.checkLogin(req));
//    }

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody MemberDTO req){
        HashMap<String, String> check = new HashMap<String, String>();
        check.put("key", memberService.checkLogin(req));
        return ResponseEntity.ok(check);
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateUser(@RequestBody MemberDTO req, @PathVariable("id") Long id) {
//        req.setId(id);
//        return ResponseEntity.ok(req);
//    }
//
//    @DeleteMapping ("/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        return "Success";
//    }
}
