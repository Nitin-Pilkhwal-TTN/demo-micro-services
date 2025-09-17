package com.question.questionservice.repository;

import com.question.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {

}
