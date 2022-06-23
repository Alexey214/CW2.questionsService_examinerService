package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public MathQuestionServiceImpl(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        Question questionTmp;
        if (questionRepository.getAll().isEmpty()) {
            return questionTmp = new Question("ОШИБКА", "ОШИБКА");
        }
        Random random = new Random();
        int rand = random.nextInt(questionRepository.getAll().size());
        List<Question> questionList = questionRepository.getAll().stream().collect(Collectors.toList());
        return questionTmp = questionList.get(rand);
    }

    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(question, answer);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }
}
