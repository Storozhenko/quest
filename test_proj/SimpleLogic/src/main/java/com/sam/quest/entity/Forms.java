package com.sam.quest.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="forms")
public class Forms {
    private Long formId;
    private String formName;
    private Users userId;
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
