package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.StudentTestingService;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentTestingService service = context.getBean(StudentTestingService.class);
        service.startStudentTesting();
    }
}