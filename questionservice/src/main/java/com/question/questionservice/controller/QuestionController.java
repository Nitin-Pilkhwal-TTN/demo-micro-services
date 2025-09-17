package com.question.questionservice.controller;

import com.question.questionservice.dto.response.QuestionResponseDTO;
import com.question.questionservice.service.QuestionService;
import com.question.questionservice.dto.request.QuestionRequestDTO;
import com.question.questionservice.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService quizService;

    @PostMapping("/add")
    public ResponseEntity<Question> addQuiz(@RequestBody QuestionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.addQuiz(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionResponseDTO>> findAll() {
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }
}
