package com.question.questionservice.service;

import com.question.questionservice.dto.request.QuestionRequestDTO;
import com.question.questionservice.dto.response.QuestionResponseDTO;
import com.question.questionservice.entity.Question;

import java.util.List;

public interface QuestionService {

    Question addQuiz(QuestionRequestDTO quiz);

    List<QuestionResponseDTO> findAll();

    QuestionResponseDTO getQuizById(Long id);
}
