package ru.otus.service;

import ru.otus.domain.Question;

import java.util.ArrayList;

public interface ParserCsvService {

    ArrayList<Question> getQuestionList(String filePath);
}
