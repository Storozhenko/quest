package com.sam.quest.web.validator;

import com.sam.quest.dto.AnswerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class AnswerValidator <E> implements Validator{

    public boolean supports(Class<?> clazz) {
        return AnswerDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        AnswerDTO answQuestion = (AnswerDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "questionAnswer", "label.validator.answerEmpty");
    }
}