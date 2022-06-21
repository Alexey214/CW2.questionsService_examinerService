package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final Set<Question> questions;

    public QuestionServiceImpl() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(@NonNull String question, @NonNull String answer) {
        Question questionTmp = isNull(question, answer);
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

    @Override
    public Question getRandomQuestion() {
        Question questionTmp;
        if (questions.isEmpty()) {
            return questionTmp = new Question("ОШИБКА", "ОШИБКА");
        }
        Random random = new Random();
        int rand = random.nextInt(questions.size());
        List<Question> questionList = questions.stream().collect(Collectors.toList());
        return questionTmp = questionList.get(rand);
    }

    //Сервисные методы:
    private Question isNull(String question, String answer) {
        Question questionTmp;
        if (question != null && answer != null && question != "" && answer != "") {
            return questionTmp = new Question(question, answer);
        }
        return questionTmp = new Question("ОШИБКА", "ОШИБКА");
    }
}
