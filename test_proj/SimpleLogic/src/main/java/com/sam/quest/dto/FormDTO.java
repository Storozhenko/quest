package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.TextLength;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class FormDTO {
    private long formId;
    private String formName;
    private String formDescr;
    private String username;

    public FormDTO(String formName, String formDescr) {
        this.formName = formName;
        this.formDescr = formDescr;
    }
    public FormDTO() {
    }

    @Required
    @TextLength(minLength = 0, maxLength = 45)
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

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
