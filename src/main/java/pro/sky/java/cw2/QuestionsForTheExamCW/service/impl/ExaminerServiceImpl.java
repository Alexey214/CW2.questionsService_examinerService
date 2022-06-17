package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.ExaminerService;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
