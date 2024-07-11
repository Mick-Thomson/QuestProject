package com.thomson.questproject.service;

import com.thomson.questproject.model.Answer;
import com.thomson.questproject.model.Data;
import com.thomson.questproject.model.Question;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {

    QuestionService questionService = Mockito.spy(QuestionService.class);
    Data result = questionService.getResult();


    @Test
    void whenComesFirstQuestionReturnFirstAndSecondAnswersTest () {
        List<Integer> answersIds = List.of(1, 2);
        List<Answer> expectedAnswers = result.getAnswers().stream()
                .filter(answer -> answersIds.contains(answer.getId()))
                .collect(Collectors.toList());

        assertEquals(expectedAnswers, questionService.getAnswersByQuestionId(1));
    }

    @Test
    void whenComesFirstAnswerReturnThirdQuestionTest() {
        Question expectedQuestion = result.getQuestions().get(2);

        assertEquals(expectedQuestion, questionService.getQuestionByAnswerId(1));
    }
}