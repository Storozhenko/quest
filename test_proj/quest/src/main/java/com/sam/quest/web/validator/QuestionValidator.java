package com.sam.quest.web.validator;

import com.sam.quest.dto.QuestionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class QuestionValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return QuestionDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        QuestionDTO question = (QuestionDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "questionName", "label.validator.questionNameEmpty");
        String questName = question.getQuestionName();
        if ((questName.length()) > 45) {
            errors.rejectValue("questionName", "label.validator.questionNameTooLong");
        }
    }
}