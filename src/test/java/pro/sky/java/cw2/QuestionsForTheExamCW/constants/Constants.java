package pro.sky.java.cw2.QuestionsForTheExamCW.constants;

import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;

import java.util.Set;

public class Constants {

    //For QuestionService
    public static final Question DEFAULT_QUESTION_1 = new Question("1+1?", "2");
    public static final Question DEFAULT_QUESTION_2 = new Question("2+2?", "4");
    public static final Question DEFAULT_QUESTION_3 = new Question("3+3?", "6");
    public static final String STRING_DEFAULT_CORRECT_ARGUMENT_1 = "1+1?";
    public static final String STRING_DEFAULT_CORRECT_ARGUMENT_2 = "2";
    public static final String STRING_NOT_CORRECT_ARGUMENT = "";
    public static final Question QUESTION_NULL = new Question(null, null);
    public static final Question QUESTION_NOT_CORRECT_1 = new Question("", "2");
    public static final Question QUESTION_NOT_CORRECT_2 = new Question("1+1?", "");
    public static final Question QUESTION_EXCEPTION = new Question("ОШИБКА", "ОШИБКА");

    //For ExaminerService
    public static final Set<Question> DEFAULT_QUESTION_SET_ALL = Set.of(
            DEFAULT_QUESTION_1,
            DEFAULT_QUESTION_2,
            DEFAULT_QUESTION_3
    );

    public static final Set<Question> DEFAULT_QUESTION_SET_ONE = Set.of(
            DEFAULT_QUESTION_1
    );
}
