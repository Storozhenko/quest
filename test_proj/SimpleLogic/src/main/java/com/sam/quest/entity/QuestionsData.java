package com.sam.quest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="questions_data")
public class QuestionsData implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="question_data_id")
    private Long questionDataId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    private Questions questionId;
    @Column(name="question_variant")
    private int questionVariant;
    @Column(name="question_data")
    private String questionData;

    public Long getQuestionDataId() {
        return questionDataId;
    }

    public void setQuestionDataId(Long questionDataId) {
        this.questionDataId = questionDataId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public int getQuestionVariant() {
        return questionVariant;
    }

    public void setQuestionVariant(int questionVariant) {
        this.questionVariant = questionVariant;
    }

    public String getQuestionData() {
        return questionData;
    }

    public void setQuestionData(String questionData) {
        this.questionData = questionData;
    }
}
