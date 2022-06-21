package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.BadRequest;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.ExaminerService;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequestScope
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;
    private Set<Question> questionSet = new HashSet<>();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadRequest();
        }
        if (amount != questionSet.size()) {
            questionSet.add(questionService.getRandomQuestion());
            getQuestions(amount);
        }
        return questionSet;
    }
}
