package com.sam.quest.web.validator;

import com.sam.quest.web.dto.FormDTO;
import com.sam.quest.web.dto.LoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class FormValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return FormDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        FormDTO form = (FormDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formName", "label.validator.formNameEmpty");
        String formName = form.getFormName();
        if ((formName.length()) > 20) {
            errors.rejectValue("formName", "label.validator.formNameTooLong");
        }
    }
}