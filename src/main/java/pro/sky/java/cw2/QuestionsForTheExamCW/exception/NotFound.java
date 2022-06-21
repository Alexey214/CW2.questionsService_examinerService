package pro.sky.java.cw2.QuestionsForTheExamCW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
    public NotFound() {
        System.out.println("\nОтсутствует информация в БД по данному запросу");
    }
}
