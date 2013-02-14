package com.sam.quest.web.validator;

import com.sam.quest.web.form.LoginForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class LoginValidator implements Validator{
    private String emptyUsername;
    private String longUsername;
    private String emptyPassword;

    public boolean supports(Class<?> clazz) {
        return LoginForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        LoginForm loginForm = (LoginForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "label.validator.usernameEmpty");
        String username = loginForm.getUsername();
        if ((username.length()) > 16) {
            errors.rejectValue("username", "label.validator.usernameTooLong");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.validator.passwordEmpty");
    }

    public String getEmptyUsername() {
        return emptyUsername;
    }

    public void setEmptyUsername(String emptyUsername) {
        this.emptyUsername = emptyUsername;
    }

    public String getLongUsername() {
        return longUsername;
    }

    public void setLongUsername(String longUsername) {
        this.longUsername = longUsername;
    }

    public String getEmptyPassword() {
        return emptyPassword;
    }

    public void setEmptyPassword(String emptyPassword) {
        this.emptyPassword = emptyPassword;
    }
}