package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.domain.Question;
import ru.otus.domain.Student;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@Service
public class StudentTestingServiceImpl implements  StudentTestingService {

    private final static int RIGHT_ANSWER = 1;
    private final static int DEFAULT_MARK = 0;
    private final ParserCsvService csvParser;
    private final MessageSource messageSource;
    private final Locale locale;

    @Autowired
    public StudentTestingServiceImpl(ParserCsvService csvParser, MessageSource messageSource, Locale locale) {
        this.csvParser = csvParser;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public void startStudentTesting() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        greetings(student, scanner);
        questionsTest(csvParser.getQuestionList(), student, scanner);
        scanner.close();
        System.out.println(messageSource.getMessage("result.msg.title"
                          , new Object[]{student.getName(), student.getAge(), student.getMark()}
                          , locale));
    }

    private void questionsTest(ArrayList<Question> questionList, Student student, Scanner scanner) {
        student.setMark(DEFAULT_MARK);
        for (Question question : questionList) {
            System.out.println(question.getText());
            System.out.println(question.getOptions());
            if (scanner.nextLine().equalsIgnoreCase(question.getAnswer())){
                student.setMark(student.getMark() + RIGHT_ANSWER);
            }
        }
    }

    private void greetings(Student student, Scanner scanner) {
        System.out.print(messageSource.getMessage("name.msg.title",new String[]{},locale));
        student.setName(scanner.nextLine());
        System.out.print(messageSource.getMessage("age.msg.title",new String[]{},locale));
        try {
            student.setAge(Integer.valueOf(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println(messageSource.getMessage("error.msg.title",new String[]{},locale));
            greetings(student, scanner);
        }
    }
}
