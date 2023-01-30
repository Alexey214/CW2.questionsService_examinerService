package pro.sky.java.cw2.QuestionsForTheExamCW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowed extends RuntimeException {
    public MethodNotAllowed() {
        System.out.println("\nMethod Not Allowed");
    }
}
