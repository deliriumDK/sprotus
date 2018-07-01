package ru.otus.service;

import ru.otus.dao.IStudentTestingDao;

public class StudentTestingServiceImpl implements  StudentTestingService {

    private IStudentTestingDao dao;

    public StudentTestingServiceImpl(IStudentTestingDao dao) {
        this.dao = dao;
    }

    public void startStudentTesting(ParserCsvService service, String filePath) {
        dao.startStudentTesting(service.getQuestionList(filePath));
    }
}
