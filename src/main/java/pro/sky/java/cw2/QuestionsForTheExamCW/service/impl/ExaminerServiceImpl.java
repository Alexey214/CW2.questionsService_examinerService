package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.BadRequest;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.ExaminerService;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequestScope
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService javaQuestionServiceImpl;
    private QuestionService mathQuestionServiceImpl;
    private QuestionRepository javaQuestionRepository;
    private QuestionRepository mathQuestionRepository;

    private Set<Question> questionSet = new HashSet<>();

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionServiceImpl,
            @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionServiceImpl,
            @Qualifier("javaQuestionRepository") QuestionRepository javaQuestionRepository,
            @Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.javaQuestionServiceImpl = javaQuestionServiceImpl;
        this.mathQuestionServiceImpl = mathQuestionServiceImpl;
        this.javaQuestionRepository = javaQuestionRepository;
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > (javaQuestionRepository.getAll().size() + mathQuestionRepository.getAll().size())) {
            throw new BadRequest();
        }
        if (amount != questionSet.size()) {
            if (javaQuestionRepository.getAll().size() != 0) {
                questionSet.add(javaQuestionServiceImpl.getRandomQuestion());
            }
            if (amount == questionSet.size()) {
                return questionSet;
            }
            questionSet.add(mathQuestionServiceImpl.getRandomQuestion());
            getQuestions(amount);
        }
        return questionSet;
    }
}
