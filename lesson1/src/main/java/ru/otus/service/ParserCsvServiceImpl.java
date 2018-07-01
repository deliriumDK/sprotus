package ru.otus.service;

import ru.otus.dao.IParserCsvDao;
import ru.otus.domain.Question;

import java.util.ArrayList;

public class ParserCsvServiceImpl implements ParserCsvService {

    private IParserCsvDao dao;

    public ParserCsvServiceImpl(IParserCsvDao dao) {
        this.dao = dao;
    }

    public ArrayList<Question> getQuestionList(String filePath) {
        return dao.getQuestionList(filePath);
    }
}
