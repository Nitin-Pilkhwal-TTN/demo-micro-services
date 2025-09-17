package com.question.questionservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponseDTO {

    private Long id;

    private String questionStatement;

    private String answer;
}
