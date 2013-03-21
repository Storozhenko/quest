package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.Validatable;

import java.util.List;

@Validatable
public class QuestionDTO {
    private long questionId;
    private String questionName;
    private String questionDescr;
    private String questionType;
    private List<String> questionOptions;

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

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public List<String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<String> questionOptions) {
        this.questionOptions = questionOptions;
    }
}
