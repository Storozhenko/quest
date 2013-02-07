package com.sam.quest.entity;

import javax.persistence.*;

@Entity
@Table(name="answ_questions")
public class AnswQuestions {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="answ_question_id")
    private Long answQuestionId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="answ_id")
    private AnswForms answId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    private Questions questionId;
    @Column(name="user_answer")
    private String userAnswer;

    public Long getAnswQuestionId() {
        return answQuestionId;
    }

    public void setAnswQuestionId(Long answQuestionId) {
        this.answQuestionId = answQuestionId;
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
