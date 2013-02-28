package com.sam.quest.dto;


import java.sql.Timestamp;

public class AnswFormDTO {
    private Long answId;
    private String formName;
    private String formDescr;
    private String username;
    private Timestamp answDatetime;

    public Long getAnswId() {
        return answId;
    }

    public void setAnswId(Long answId) {
        this.answId = answId;
    }

    public Timestamp getAnswDatetime() {
        return answDatetime;
    }

    public void setAnswDatetime(Timestamp answDatetime) {
        this.answDatetime = answDatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AnswFormDTO() {
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormDescr() {
        return formDescr;
    }

    public void setFormDescr(String formDescr) {
        this.formDescr = formDescr;
    }
}
