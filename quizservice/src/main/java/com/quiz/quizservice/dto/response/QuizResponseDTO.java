package com.quiz.quizservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponseDTO {

    private Long id;

    private String title;

    private String description;

    private List<QuestionResponseDTO> questions;
}
