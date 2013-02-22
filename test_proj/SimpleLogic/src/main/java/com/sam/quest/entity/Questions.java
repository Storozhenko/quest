package com.sam.quest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="questions")
public class Questions implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="question_id")
    private Long questionId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="form_id")
    private Forms formId;
    @Column(name="question_name")
    private String questionName;
    @Column(name="question_type")
    private Integer questionType;
    @Column(name="question_descr")
    private String questionDescr;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionId")
    private Set<AnswQuestions> answQuestions;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionId")
    private Set<QuestionsData> questionsData;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Forms getFormId() {
        return formId;
    }

    public void setFormId(Forms formId) {
        this.formId = formId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
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

    public Set<QuestionsData> getQuestionsData() {
        return questionsData;
    }

    public void setQuestionsData(Set<QuestionsData> questionsData) {
        this.questionsData = questionsData;
    }

}
