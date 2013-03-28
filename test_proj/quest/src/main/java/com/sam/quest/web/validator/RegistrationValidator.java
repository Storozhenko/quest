package com.sam.quest.web.validator;

import com.sam.quest.dto.RegistrationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class RegistrationValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return RegistrationDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        RegistrationDTO regForm = (RegistrationDTO) target;
        if (!regForm.getPassword().equals(regForm.getConfirmPassword())) {
            errors.rejectValue("password", "label.validator.j_password.notMatch");
        }
    }
}