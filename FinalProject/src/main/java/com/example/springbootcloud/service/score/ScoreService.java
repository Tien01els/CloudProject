package com.example.springbootcloud.service.score;

import com.example.springbootcloud.model.dto.ScoreDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public interface ScoreService {
    ScoreDTO createScore(ScoreDTO scoreDTO);
    ScoreDTO updateScore(ScoreDTO scoreDTO);
    void deleteScore(ScoreDTO scoreDTO);
    ArrayList<HashMap<String, String>> getCourseRegistered(Long student_id);
}
