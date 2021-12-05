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

//    @PostMapping("/login")
//    public ResponseEntity<?> checkLogin(@RequestBody MemberDTO req){
//        HashMap<String, String> check = new HashMap<String, String>();
//        check.put("key", memberService.checkLogin(req));
//        return ResponseEntity.ok(check);
//    }

    @RequestMapping("")
    public ResponseEntity<?> checkLogin(@RequestBody MemberDTO req){
        HashMap<String, String> check = new HashMap<String, String>();
        check.put("key", memberService.checkLogin(req));
        return ResponseEntity.ok(check);
    }
}
