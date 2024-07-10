package com.thomson.questproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;



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