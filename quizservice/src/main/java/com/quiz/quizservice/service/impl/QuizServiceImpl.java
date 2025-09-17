package com.quiz.quizservice.service.impl;

import com.quiz.quizservice.dto.request.QuizRequestDTO;
import com.quiz.quizservice.dto.response.QuestionResponseDTO;
import com.quiz.quizservice.dto.response.QuizResponseDTO;
import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.repository.QuizRepo;
import com.quiz.quizservice.service.QuizService;
import com.quiz.quizservice.service.client.QuestionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepo quizRepo;
    private final QuestionClient questionClient;

    @Override
    public QuizResponseDTO addQuiz(QuizRequestDTO dto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(dto.getTitle());
        quiz.setDescription(dto.getDescription());
        quiz = quizRepo.save(quiz);
        return new QuizResponseDTO(quiz.getId(),quiz.getTitle(),quiz.getDescription(),null);
    }

    @Override
    public List<QuizResponseDTO> findAll() {
        List<Quiz> quizzes = quizRepo.findAll();
        List<QuestionResponseDTO> questions = questionClient.findAll();
        return quizzes.stream().map(
                quiz ->
                    new QuizResponseDTO(quiz.getId(),quiz.getTitle(),quiz.getDescription(),questions)
        ).toList();
    }

    @Override
    public QuizResponseDTO getQuizById(Long id) {
        Quiz quiz = quizRepo.findById(id)
                .orElse(null);
        return (quiz == null) ? null :
                new QuizResponseDTO(quiz.getId(),quiz.getTitle(),quiz.getDescription(),null);
    }
}
