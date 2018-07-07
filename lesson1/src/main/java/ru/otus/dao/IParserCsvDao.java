package ru.otus.dao;

import ru.otus.domain.Question;

import java.util.ArrayList;
import java.util.Locale;

public interface IParserCsvDao {

    ArrayList<Question> getQuestionList(String filePath, Locale locale);
}
