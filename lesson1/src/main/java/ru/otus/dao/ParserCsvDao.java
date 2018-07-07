package ru.otus.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;
import ru.otus.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Repository
public class ParserCsvDao implements IParserCsvDao {

    public ArrayList<Question> getQuestionList(String filePath, Locale locale) {
        ArrayList<Question> questionList = new ArrayList<>();
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(filePath));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equalsIgnoreCase(locale.toString())) {
                    Question question = new Question();
                    question.setText(line[1]);
                    question.setAnswer(line[2]);
                    List<String> list = Arrays.asList(line[3], line[4], line[5], line[6]);
                    question.setOptions(list);
                    questionList.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  questionList;
    }
}
