package com.sam.quest.entity;

import java.sql.Timestamp;

public class AnswForms {
    private Long answId;
    private Forms formId;
    private Users userId;
    private Timestamp answDatetime;

    public Long getAnswId() {
        return answId;
    }

    public void setAnswId(Long answId) {
        this.answId = answId;
    }

    public Forms getFormId() {
        return formId;
    }

    public void setFormId(Forms formId) {
        this.formId = formId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Timestamp getAnswDatetime() {
        return answDatetime;
    }

    public void setAnswDatetime(Timestamp answDatetime) {
        this.answDatetime = answDatetime;
    }
}
