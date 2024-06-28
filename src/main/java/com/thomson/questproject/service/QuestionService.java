package com.thomson.questproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thomson.questproject.model.Answer;
import com.thomson.questproject.model.Data;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionService {
    private Data result = new Data();

    @SneakyThrows
    public QuestionService() {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("data.json")).toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        ObjectMapper om = new ObjectMapper();
        result = om.readValue(data, Data.class);
    }

    public List<Answer> answersByQuestionId(Integer questionId) {
        List<Answer> answers = result.getAnswers();
        return answers;
    }
    public Data readFromFile() {
        return result;
    }
}
