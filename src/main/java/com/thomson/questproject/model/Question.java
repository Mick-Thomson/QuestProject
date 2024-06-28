package com.thomson.questproject.model;

import lombok.Data;

import java.util.List;

@Data
public class Question{
    public int id;
    public String message;
    public List<Integer> answers;
    public boolean failed;
    public boolean success;
}