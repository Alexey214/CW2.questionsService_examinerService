package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.impl.MathQuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.cw2.QuestionsForTheExamCW.constants.Constants.*;

class MathQuestionServiceImplTest {

    private final QuestionRepository out = new MathQuestionRepository();
    private final QuestionService out1 = new MathQuestionServiceImpl(out);

    @Test
    void addCorrectRequest() {
        Question result = out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        assertEquals(DEFAULT_QUESTION_1, result);
    }

    @Test
    void testAddNotCorrectRequests() {
        Question result = out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, STRING_NOT_CORRECT_ARGUMENT);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.add(STRING_NOT_CORRECT_ARGUMENT, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, null);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.add(null, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        assertEquals(QUESTION_EXCEPTION, result);
    }

    @Test
    void removeCorrectRequest() {
        out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        Question result = out.remove(DEFAULT_QUESTION_1);
        assertEquals(result, DEFAULT_QUESTION_1);
        assertFalse(out.toString().contains(DEFAULT_QUESTION_1.toString()));
    }

    @Test
    void testRemoveNotCorrectRequests() {
        Question result = out.remove(DEFAULT_QUESTION_1);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.remove(QUESTION_NULL);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.remove(QUESTION_NOT_CORRECT_1);
        assertEquals(QUESTION_EXCEPTION, result);
        result = out.remove(QUESTION_NOT_CORRECT_2);
        assertEquals(QUESTION_EXCEPTION, result);

    }

    @Test
    void getAll() {
        out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        assertTrue(out.getAll().toString().contains(DEFAULT_QUESTION_1.toString()));
    }

    @Test
    void getRandomQuestionCorrectRequest() {
        out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1, STRING_DEFAULT_CORRECT_ARGUMENT_2);
        out.add(STRING_DEFAULT_CORRECT_ARGUMENT_1 + 1, STRING_DEFAULT_CORRECT_ARGUMENT_2 + 1);
        assertTrue(out.getAll().contains(out1.getRandomQuestion()));
    }

    @Test
    void getRandomQuestionNotCorrectRequest() {
        Question result = out1.getRandomQuestion();
        assertEquals(QUESTION_EXCEPTION, result);
    }
}