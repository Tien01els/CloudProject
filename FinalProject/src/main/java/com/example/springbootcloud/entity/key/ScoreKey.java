package com.example.springbootcloud.entity.key;

import com.example.springbootcloud.entity.Account;
import com.example.springbootcloud.entity.Course;
import com.example.springbootcloud.entity.Student;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ScoreKey implements Serializable {

    @Column(name = "student_id")
    private long student_id;

    @Column(name = "course_id")
    private long course_id;
}
