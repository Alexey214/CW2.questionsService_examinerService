package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
