package com.thomson.questproject.model;

/**
 * Класс, содержащий данные ответа
 */
public class Answer {
    private int id;
    private String choice;
    private int question;

    public Answer() {
    }

    public Answer(int id, String choice, int question) {
        this.id = id;
        this.choice = choice;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
}