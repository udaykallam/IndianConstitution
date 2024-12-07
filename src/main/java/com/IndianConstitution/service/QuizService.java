package com.IndianConstitution.service;

import com.IndianConstitution.model.Quiz;
import com.IndianConstitution.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public int evaluateQuiz(List<Long> questionIds, List<String> userAnswers) {
        int score = 0;
        List<Quiz> quizzes = quizRepository.findAllById(questionIds);

        for (int i = 0; i < quizzes.size(); i++) {
            if (quizzes.get(i).getAnswer().equals(userAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
