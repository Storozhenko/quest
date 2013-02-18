package com.sam.quest.web.validator;

import com.sam.quest.web.dto.LoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class LoginValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return LoginDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        LoginDTO loginForm = (LoginDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "label.validator.usernameEmpty");
        String username = loginForm.getUsername();
        if ((username.length()) > 16) {
            errors.rejectValue("username", "label.validator.usernameTooLong");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.validator.passwordEmpty");
    }
}