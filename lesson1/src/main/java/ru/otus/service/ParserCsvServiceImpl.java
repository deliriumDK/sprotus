package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.dao.IParserCsvDao;
import ru.otus.domain.Question;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class ParserCsvServiceImpl implements ParserCsvService {

    private final IParserCsvDao dao;
    private final String filePath;
    private final Locale locale;

    @Autowired
    public ParserCsvServiceImpl(IParserCsvDao dao, @Value("${csv.path}") String filePath, Locale locale) {
        this.filePath = filePath;
        this.locale = locale;
        this.dao = dao;
    }

    public ArrayList<Question> getQuestionList() {
        return dao.getQuestionList(filePath, locale);
    }
}
