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
    @Column(name="question_option")
    private int questionOption;
    @Column(name="option_data")
    private String optionData;

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

    public int getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(int questionVariant) {
        this.questionOption = questionVariant;
    }

    public String getOptionData() {
        return optionData;
    }

    public void setOptionData(String questionData) {
        this.optionData = questionData;
    }
}
