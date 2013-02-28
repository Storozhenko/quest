package com.sam.quest.dto;


import java.util.List;

public class AnswQuestionDTO {
    private String questionName;
    private List<String> userAnswer;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<String> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<String> userAnswer) {
        this.userAnswer = userAnswer;
    }
}
