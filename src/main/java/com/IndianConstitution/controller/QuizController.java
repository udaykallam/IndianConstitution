package com.IndianConstitution.controller;

import com.IndianConstitution.model.Quiz;
import com.IndianConstitution.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173") // Update as per frontend URL
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/evaluate")
    public int evaluateQuiz(@RequestBody QuizEvaluationRequest request) {
        return quizService.evaluateQuiz(request.getQuestionIds(), request.getUserAnswers());
    }

    // Request DTO for quiz evaluation
    public static class QuizEvaluationRequest {
        private List<Long> questionIds;
        private List<String> userAnswers;

        // Getters and Setters
        public List<Long> getQuestionIds() {
            return questionIds;
        }

        public void setQuestionIds(List<Long> questionIds) {
            this.questionIds = questionIds;
        }

        public List<String> getUserAnswers() {
            return userAnswers;
        }

        public void setUserAnswers(List<String> userAnswers) {
            this.userAnswers = userAnswers;
        }
    }
}
