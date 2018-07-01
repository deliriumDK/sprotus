package ru.otus.dao;

import ru.otus.domain.Question;
import ru.otus.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestingDao implements IStudentTestingDao {

    public void startStudentTesting(ArrayList<Question> questionList) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        greetings(student, scanner);
        questionsTest(questionList, student, scanner);
        scanner.close();
        System.out.println("Студент: " + student.getName()
                + " Возраст: " + student.getAge()
                + " Оцента: " + student.getMark());
    }

    private void questionsTest(ArrayList<Question> questionList, Student student, Scanner scanner) {
        student.setMark(0);
        for (Question question : questionList) {
            System.out.println(question.getText());
            System.out.println(question.getOptions());
            if (scanner.nextLine().equalsIgnoreCase(question.getAnswer())){
                student.setMark(student.getMark() + 1);
            }
        }
    }

    private void greetings(Student student, Scanner scanner) {
        System.out.print("Enter your name: ");
        student.setName(scanner.nextLine());
        System.out.print("Enter your age in numbers: ");
        try {
            student.setAge(Integer.valueOf(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect age format. Try again.");
            greetings(student, scanner);
        }
    }

}
