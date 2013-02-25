package com.sam.quest.web.validator;

import com.sam.quest.dto.AnswQuestionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class AnswerValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return AnswQuestionDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        AnswQuestionDTO answQuestion = (AnswQuestionDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "questionAnswer", "label.validator.answerEmpty");
    }
}