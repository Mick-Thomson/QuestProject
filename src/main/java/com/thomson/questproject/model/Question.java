package com.thomson.questproject.model;

import java.util.List;

/**
 * Класс, содержащий данные вопроса
 */
public class Question{
    public int id;
    public String message;
    public List<Integer> answers;
    public boolean failed;
    public boolean success;

    public Question() {
    }

    public Question(int id, String message, List<Integer> answers, boolean failed, boolean success) {
        this.id = id;
        this.message = message;
        this.answers = answers;
        this.failed = failed;
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}