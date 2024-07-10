package com.thomson.questproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thomson.questproject.model.Answer;
import com.thomson.questproject.model.Data;
import com.thomson.questproject.model.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionService {
    private final Data result;

    /**
     * 
     */
    public QuestionService() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("data.json")).toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        ObjectMapper om = new ObjectMapper();
        result = om.readValue(data, Data.class);
    }

    /**
     *
     * @param questionId
     * @return
     */
    public List<Answer> answersByQuestionId(Integer questionId) {
        /**
         * Достаём из распарсенного json-файла List<Question> отфильтрованный по условию:
         * id вопроса совпадает с переданным id
         * Возвращает первый найденный элемент
         */
        var question = result.getQuestions().stream()
                .filter(q -> Objects.equals(q.getId(), questionId))
                .findFirst();

        /**
         * Если question.isPresent, то получаем список id ответов возможных ответов из вопроса
         * и возвращаем списк ответов, полученных из Data и отфильтрованных по условию:
         * id списка возможных ответов вопроса совпадают с имеющимися в общей базе
         * Возвращает List<Answer>
         */
        if (question.isPresent()) {
            var answersIds = question.get().getAnswers();
            return result.getAnswers().stream()
                    .filter(answer -> answersIds.contains(answer.getId()))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     *
     * @param answerId
     * @return
     */
    public Question getQuestionByAnswerId(Integer answerId) {
        var answer = result.getAnswers().stream()
                .filter(q -> Objects.equals(q.getId(), answerId))
                .findFirst();

        if (answer.isPresent()) {
            var question = result.getQuestions()
                    .stream()
                    .filter(q -> Objects.equals(q.getId(), answer.get().getQuestion()))
                    .findFirst();
            if (question.isPresent()) {
                return question.get();
            }
        }
        throw new RuntimeException("Question not found");
    }

    /**
     *
     * @return
     */
    public Data readFromFile() {
        return result;
    }
}
