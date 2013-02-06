package com.sam.quest.entity;

public class AnswQuestions {
    private AnswForms answId;
    private Questions questionId;
    private String userAnswer;

    public AnswForms getAnswId() {
        return answId;
    }

    public void setAnswId(AnswForms answId) {
        this.answId = answId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
