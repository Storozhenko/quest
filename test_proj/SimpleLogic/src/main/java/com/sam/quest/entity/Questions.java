package com.sam.quest.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="questions")
public class Questions {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="question_id")
    private Long questionId;
    @Column(name="question_name")
    private String questionName;
    @Column(name="question_answer")
    private String questionAnswer;
    @Column(name="question_type")
    private String questionType;
    @Column(name="question_descr")
    private String questionDescr;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<AnswQuestions> answQuestions;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<FormsData> formsData;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<QuestionsData> questionsData;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDescr() {
        return questionDescr;
    }

    public void setQuestionDescr(String questionDescr) {
        this.questionDescr = questionDescr;
    }

    public Set<AnswQuestions> getAnswQuestions() {
        return answQuestions;
    }

    public void setAnswQuestions(Set<AnswQuestions> answQuestions) {
        this.answQuestions = answQuestions;
    }

    public Set<FormsData> getFormsData() {
        return formsData;
    }

    public void setFormsData(Set<FormsData> formsData) {
        this.formsData = formsData;
    }

    public Set<QuestionsData> getQuestionsData() {
        return questionsData;
    }

    public void setQuestionsData(Set<QuestionsData> questionsData) {
        this.questionsData = questionsData;
    }

}
