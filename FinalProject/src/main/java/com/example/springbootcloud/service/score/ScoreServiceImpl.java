package com.example.springbootcloud.service.score;

import com.example.springbootcloud.converter.ScoreConverter;
import com.example.springbootcloud.entity.Score;
import com.example.springbootcloud.model.dto.ScoreDTO;
import com.example.springbootcloud.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreConverter scoreConverter;

    @Override
    public ScoreDTO createScore(ScoreDTO scoreDTO){
        Score score = scoreConverter.toEntity(scoreDTO);
        score = scoreRepository.save(score);
        return scoreConverter.toDTO(score);
    }

    @Override
    public ScoreDTO updateScore(ScoreDTO scoreDTO){
        Score existingScore = scoreRepository.findScoreByCourseIdAndStudentId(scoreDTO.getCourse_id(), scoreDTO.getStudent_id());
        assert existingScore != null;
        Score score = scoreConverter.toExistingEntity(existingScore, scoreDTO);
        score = scoreRepository.save(score);
        return scoreConverter.toDTO(score);
    }

    @Override
    public void deleteScore(ScoreDTO scoreDTO){
        scoreRepository.deleteScoreByCourseIdAndStudentId(scoreDTO.getCourse_id(), scoreDTO.getStudent_id());
    }
}
