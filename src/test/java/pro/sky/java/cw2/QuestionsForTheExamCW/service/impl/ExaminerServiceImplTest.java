package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.exception.BadRequest;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.cw2.QuestionsForTheExamCW.constants.Constants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionServiceMock;


    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionsWhenAmountMoreSize() {
        when(questionServiceMock.getAll())
                .thenReturn(DEFAULT_QUESTION_SET_ALL);
        assertThrows(BadRequest.class, () -> out.getQuestions(4));
    }

    @Test
    void getQuestionsWhenAmountLessSize() {
        when(questionServiceMock.getRandomQuestion())
                .thenReturn(DEFAULT_QUESTION_1);
        when(questionServiceMock.getAll())
                .thenReturn(DEFAULT_QUESTION_SET_ONE);
        Set<Question> result = (Set<Question>) out.getQuestions(1);
        assertTrue(result.contains(DEFAULT_QUESTION_1));
    }
}