package com.example.springbootcloud.service.score;

import com.example.springbootcloud.converter.ScoreConverter;
import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.entity.Score;
import com.example.springbootcloud.entity.Student;
import com.example.springbootcloud.model.dto.CourseDTO;
import com.example.springbootcloud.model.dto.ScoreDTO;
import com.example.springbootcloud.repositories.ScoreRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
    public String checkRegister(ScoreDTO scoreDTO){
        Score existingScore = scoreRepository.findScoreByCourseIdAndStudentId(scoreDTO.getCourse_id(), scoreDTO.getStudent_id());
//        assert existingScore != null;
        if(existingScore != null){
            return "Registered";
        }else{
            return "Unregistered";
        }
    }

    @Override
    public void deleteScore(ScoreDTO scoreDTO){
        scoreRepository.deleteScoreByCourseIdAndStudentId(scoreDTO.getCourse_id(), scoreDTO.getStudent_id());
    }

    @Override
    public ArrayList<HashMap<String, String>> getCourseRegistered(Long student_id){
        List<Object[]> list = scoreRepository.selectCourseRegistered(student_id);
        ArrayList<HashMap<String, String>> temp = new ArrayList<>();

        for(int i = 0; i < list.size(); ++i){
            HashMap<String, String> map = new HashMap<>();
            Course course = (Course) list.get(i)[0];
            map.put("course_id", Long.toString(course.getCourse_id()));
            map.put("name", course.getName());
            Score score = (Score) list.get(i)[1];
            map.put("scores", score.getScores());
            temp.add(map);
        }
        return temp;
    }

    @Override
    public ArrayList<HashMap<String, String>> getListStudentByCourseId(Long course_id){
        List<Object[]> list = scoreRepository.selectStudentListByCourseId(course_id);
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        for(int i = 0; i < list.size(); ++i){
            HashMap<String, String> map = new HashMap<>();
            Student student = (Student) list.get(i)[0];
            map.put("student_id", Long.toString(student.getStudent_id()));
            map.put("firstname", student.getFirstname());
            map.put("lastname", student.getLastname());
            map.put("email", student.getEmail());
            map.put("birth", student.getBirth());
            map.put("gender", student.getGender());

            Score score = (Score) list.get(i)[1];
            map.put("scores", score.getScores());

            result.add(map);
        }
        return result;
    }
}
