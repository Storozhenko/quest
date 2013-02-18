package com.sam.quest.web.validator;

import com.sam.quest.web.dto.FormDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class QuestionValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return FormDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        FormDTO form = (FormDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "label.validator.formNameEmpty");
        String formName = form.getFormName();
        if ((formName.length()) > 20) {
            errors.rejectValue("username", "label.validator.formNameTooLong");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.validator.passwordEmpty");
    }
}