package com.example.springbootcloud.service.score;

import com.example.springbootcloud.model.dto.ScoreDTO;
import org.springframework.stereotype.Service;

@Service
public interface ScoreService {
    ScoreDTO createScore(ScoreDTO scoreDTO);
    ScoreDTO updateScore(ScoreDTO scoreDTO);
    void deleteScore(ScoreDTO scoreDTO);
}
