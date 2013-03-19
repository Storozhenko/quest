package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class QuestionDTO {
    private String questionName;
    private String questionDescr;
    private String questionType;

    @Required
    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDescr() {
        return questionDescr;
    }

    public void setQuestionDescr(String questionDescr) {
        this.questionDescr = questionDescr;
    }
    @Required
    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
