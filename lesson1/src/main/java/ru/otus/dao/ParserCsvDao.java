package ru.otus.dao;

import com.opencsv.CSVReader;
import ru.otus.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserCsvDao implements IParserCsvDao {

    public ArrayList<Question> getQuestionList(String filePath) {
        ArrayList<Question> questionList = new ArrayList<Question>();
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(filePath));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Question question = new Question();
                question.setId(Integer.parseInt(line[0]));
                question.setText(line[1]);
                question.setAnswer(line[2]);
                List<String> list = Arrays.asList(line[3], line[4], line[5], line[6]);
                question.setOptions(list);
                questionList.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  questionList;
    }
}
