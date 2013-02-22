package com.sam.quest.web.dto;


public class AnswQuestionDTO {
    private String [] questionAnswer;
    private int questionNumber;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String [] getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String [] questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
