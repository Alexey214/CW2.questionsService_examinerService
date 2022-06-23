package pro.sky.java.cw2.QuestionsForTheExamCW.repository.impl;

import org.springframework.stereotype.Repository;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionTmp = dataValidation(question, answer);
        Question questionException = new Question("ОШИБКА", "ОШИБКА");
        if (!questionTmp.equals(questionException)) {
            questions.add(questionTmp);
            return questionTmp;
        }
        return questionTmp;
    }

    @Override
    public Question remove(Question question) {
        Question questionException = new Question("ОШИБКА", "ОШИБКА");
        if (!questions.contains(question)) {
            return questionException;
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @PostConstruct
    void init() {
        Question question1 = new Question("java?", "island");
        Question question2 = new Question("java??", "programming language");
        Question question3 = new Question("JAVA???", "The best!!!");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }

    //Сервисные методы:
    private Question dataValidation(String question, String answer) {
        Question questionTmp;
        if (question != null && answer != null && question != "" && answer != "" && !question.equals(answer)) {
            return questionTmp = new Question(question, answer);
        }
        return questionTmp = new Question("ОШИБКА", "ОШИБКА");
    }
}
