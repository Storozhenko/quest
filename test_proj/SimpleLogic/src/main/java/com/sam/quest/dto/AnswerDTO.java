package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class AnswerDTO {
    private String [] questionAnswer;

    @Required
    public String [] getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String [] questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
