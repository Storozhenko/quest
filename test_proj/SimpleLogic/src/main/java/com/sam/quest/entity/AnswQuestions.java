package com.sam.quest.entity;

public class AnswQuestions {
    private Long answQuestId;
    private AnswForms answId;
    private Questions questionId;
    private String userAnswer;

    public Long getAnswQuestId() {
        return answQuestId;
    }

    public void setAnswQuestId(Long answQuestId) {
        this.answQuestId = answQuestId;
    }

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
