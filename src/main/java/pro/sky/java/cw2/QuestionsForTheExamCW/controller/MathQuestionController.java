package pro.sky.java.cw2.QuestionsForTheExamCW.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.BadRequest;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.NotFound;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionServiceImpl") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/add")
    Question addQuestion(@RequestParam(name = "question", required = false) String question,
                         @RequestParam(name = "answer", required = false) String answer) {
        Question questionTmp = questionService.add(question, answer);
        Question questionException = new Question("ОШИБКА", "ОШИБКА");
        if (questionTmp.equals(questionException)) {
            throw new BadRequest();
        } else {
            return questionTmp;
        }
    }

    @GetMapping(path = "/remove")
    Question removeQuestion(@RequestParam(name = "question", required = false) String question,
                            @RequestParam(name = "answer", required = false) String answer) {
        Question questionTmp = new Question(question, answer);
        Question questionException = new Question("ОШИБКА", "ОШИБКА");
        if (question == "" && answer == "" || questionService.remove(questionTmp).equals(questionException)) {
            throw new NotFound();
        } else {
            return questionTmp;
        }
    }
}
