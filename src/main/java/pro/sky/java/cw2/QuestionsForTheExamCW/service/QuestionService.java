package pro.sky.java.cw2.QuestionsForTheExamCW.service;

import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;

import java.util.Collection;
import java.util.HashSet;

public interface QuestionService {

    Question getRandomQuestion();

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();
}
