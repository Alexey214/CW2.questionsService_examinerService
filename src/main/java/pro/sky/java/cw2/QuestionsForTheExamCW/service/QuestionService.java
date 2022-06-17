package pro.sky.java.cw2.QuestionsForTheExamCW.service;

import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection <Question> getAll();

    Question getRandomQuestion();

}
