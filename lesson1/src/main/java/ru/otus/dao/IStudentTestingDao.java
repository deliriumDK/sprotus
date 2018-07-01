package ru.otus.dao;

import ru.otus.domain.Question;

import java.util.ArrayList;

public interface IStudentTestingDao {

    void startStudentTesting(ArrayList<Question> questionList);
}
