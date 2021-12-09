package com.example.springbootcloud.controller;

import com.example.springbootcloud.model.dto.ScoreDTO;
import com.example.springbootcloud.service.score.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("")
    public ResponseEntity<?> createScore(@RequestBody ScoreDTO req){
        ScoreDTO result = scoreService.createScore(req);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScore(@PathVariable("id") Long id){
        ArrayList<HashMap<String, String>> result = scoreService.getCourseRegistered(id);
        return ResponseEntity.ok(result);
//        return null;
    }
}
