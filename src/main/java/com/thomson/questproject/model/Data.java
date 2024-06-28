package com.thomson.questproject.model;

import java.util.List;

@lombok.Data
public class Data {
    public List<Question> questions;
    public List<Answer> answers;
}