package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.TextLength;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class RegistrationDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Required
    @TextLength(minLength = 0, maxLength = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Required
    @TextLength (minLength = 0, maxLength = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Required
    @TextLength (minLength = 0, maxLength = 16)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
