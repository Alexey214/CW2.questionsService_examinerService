package pro.sky.java.cw2.QuestionsForTheExamCW.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    Collection<Question> getQuestions(@RequestParam(name = "amount", required = false) int amount) {
        return null;
    }
}
