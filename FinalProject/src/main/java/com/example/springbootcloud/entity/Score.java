package com.example.springbootcloud.entity;

import com.example.springbootcloud.entity.key.ScoreKey;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "score")
@Table(name = "score")
public class Score implements java.io.Serializable {

    @EmbeddedId
    private ScoreKey id;

    @Column(name = "scores")
    private String scores;
}
