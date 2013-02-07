package com.sam.quest.entity;

import javax.persistence.*;

@Entity
@Table(name="forms_date")
public class FormsData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="form_data_id")
    private Long formDataId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="form_id")
    private Forms formId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    private Questions questionId;

    public Long getFormDataId() {
        return formDataId;
    }

    public void setFormDataId(Long formDataId) {
        this.formDataId = formDataId;
    }

    public Forms getFormId() {
        return formId;
    }

    public void setFormId(Forms formId) {
        this.formId = formId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }
}
