package com.thomson.questproject.model;

import java.util.List;

/**
 * Класс данных в виде списков вопросов и ответов
 */
public class Data {
    public List<Question> questions;
    public List<Answer> answers;

    public Data() {
    }

    public Data(List<Question> questions, List<Answer> answers) {
        this.questions = questions;
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}