package com.quiz.quizservice.service.client;

import com.quiz.quizservice.dto.response.QuestionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionClient {

    @GetMapping("/questions/{id}")
    List<QuestionResponseDTO> findById(@PathVariable Long id);

    @GetMapping("/questions/all")
    List<QuestionResponseDTO> findAll();
}
