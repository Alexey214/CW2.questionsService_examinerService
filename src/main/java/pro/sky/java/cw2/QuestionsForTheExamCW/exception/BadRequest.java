package pro.sky.java.cw2.QuestionsForTheExamCW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {
    public BadRequest() {
        System.out.println("\nЗапрошено неверное количество вопросов. \n Повторите запрос, указав корректные данные.");
    }
}
