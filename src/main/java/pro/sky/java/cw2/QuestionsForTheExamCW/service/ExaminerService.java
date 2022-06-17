package pro.sky.java.cw2.QuestionsForTheExamCW.service;

import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
