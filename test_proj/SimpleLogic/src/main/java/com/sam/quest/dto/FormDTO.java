package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class FormDTO {
    private String formName;
    private String formDescr;

    public FormDTO(String formName, String formDescr) {
        this.formName = formName;
        this.formDescr = formDescr;
    }
    public FormDTO() {
    }

    @Required
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
