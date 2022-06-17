package pro.sky.java.cw2.QuestionsForTheExamCW.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return null;
    }

    @GetMapping(path = "/add")
    Question addQuestion(@RequestParam(name = "question", required = false) String question,
                         @RequestParam(name = "answer", required = false) String answer) {
        return null;
    }

    @GetMapping(path = "/remove")
    Question removeQuestion(@RequestParam(name = "question", required = false) String question,
                            @RequestParam(name = "answer", required = false) String answer) {
        return null;
    }
}
