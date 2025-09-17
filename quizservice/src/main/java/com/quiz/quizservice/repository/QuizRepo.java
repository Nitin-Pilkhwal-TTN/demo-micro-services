package com.quiz.quizservice.repository;

import com.quiz.quizservice.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findByTitle(String title);
}
