package ru.otus.service;

import ru.otus.dao.IParserCsvDao;
import ru.otus.domain.Question;

import java.util.ArrayList;

public class ParserCsvServiceImpl implements ParserCsvService {

    private final IParserCsvDao dao;
    private final String filePath;

    public ParserCsvServiceImpl(IParserCsvDao dao, String filePath) {
        this.filePath = filePath;
        this.dao = dao;
    }

    public ArrayList<Question> getQuestionList() {
        return dao.getQuestionList(filePath);
    }
}
