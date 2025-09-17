package com.quiz.quizservice.controller;

import com.quiz.quizservice.dto.request.QuizRequestDTO;
import com.quiz.quizservice.dto.response.QuizResponseDTO;
import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/add")
    public ResponseEntity<QuizResponseDTO> addQuiz(@RequestBody QuizRequestDTO dto) {
        return ResponseEntity.ok(quizService.addQuiz(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizResponseDTO>> findAll() {
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }
}
