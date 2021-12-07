package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
    @Query("SELECT u FROM score u WHERE u.id.course_id = ?1 and u.id.student_id =?2")
    Score findScoreByCourseIdAndStudentId(Long course_id, Long student_id);

    @Query("DELETE FROM score u WHERE u.id.course_id = ?1 and u.id.student_id =?2")
    void deleteScoreByCourseIdAndStudentId(Long course_id, Long student_id);
}
