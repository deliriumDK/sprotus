package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.ParserCsvService;
import ru.otus.service.StudentTestingService;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("application");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentTestingService service = context.getBean(StudentTestingService.class);
        ParserCsvService parserCsvService = context.getBean(ParserCsvService.class);
        service.startStudentTesting(parserCsvService, bundle.getString("csv.path"));
    }
}