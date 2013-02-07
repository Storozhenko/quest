package com.sam.quest.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="forms")
public class Forms {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="form_id")
    private Long formId;
    @Column(name="form_name")
    private String formName;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users userId;
    @Column(name="form_name")
    private Date formDate;

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }
}
