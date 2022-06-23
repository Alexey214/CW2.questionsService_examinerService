package pro.sky.java.cw2.QuestionsForTheExamCW.repository;

import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();
}
