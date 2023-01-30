package pro.sky.java.cw2.QuestionsForTheExamCW.controller;

import org.springframework.beans.BeansException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.MethodNotAllowed;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BeansException.class)
    public void MethodNotAllowedException(BeansException e) {
        System.out.println("\nMethod Not Allowed\n");
    }
}
