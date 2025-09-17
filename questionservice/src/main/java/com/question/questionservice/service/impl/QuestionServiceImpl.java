package com.question.questionservice.service.impl;

import com.question.questionservice.dto.request.QuestionRequestDTO;
import com.question.questionservice.dto.response.QuestionResponseDTO;
import com.question.questionservice.entity.Question;
import com.question.questionservice.repository.QuestionRepo;
import com.question.questionservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @Override
    public Question addQuiz(QuestionRequestDTO dto) {
        Question question = new Question();
        question.setQuestionStatement(dto.getQuestion());
        question.setAnswer(dto.getAnswer());
        return questionRepo.save(question);
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        List<Question> questions = questionRepo.findAll();
        return questions.stream().map(
                entity ->
                        new QuestionResponseDTO(entity.getId(), entity.getQuestionStatement(), entity.getAnswer())
        ).toList();
    }

    @Override
    public QuestionResponseDTO getQuizById(Long id) {
        Question question = questionRepo.findById(id)
                .orElse(null);
        return (question == null) ? null :
                new QuestionResponseDTO(question.getId(), question.getQuestionStatement(), question.getAnswer());
    }
}
