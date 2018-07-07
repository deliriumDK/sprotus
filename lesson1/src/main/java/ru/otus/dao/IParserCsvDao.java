package ru.otus.dao;

import ru.otus.domain.Question;

import java.util.ArrayList;

public interface IParserCsvDao {

    ArrayList<Question> getQuestionList(String filePath);
}
