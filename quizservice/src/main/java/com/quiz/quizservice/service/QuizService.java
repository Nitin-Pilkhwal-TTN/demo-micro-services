package com.quiz.quizservice.service;

import com.quiz.quizservice.dto.request.QuizRequestDTO;
import com.quiz.quizservice.dto.response.QuizResponseDTO;

import java.util.List;

public interface QuizService {

    QuizResponseDTO addQuiz(QuizRequestDTO quiz);

    List<QuizResponseDTO> findAll();

    QuizResponseDTO getQuizById(Long id);
}
