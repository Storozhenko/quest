package com.sam.quest.dto;

import com.sam.quest.dto.annotations.TextLength;
import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class LoginDTO {
    private String j_username;
    private String j_password;

    @Required
    @TextLength (minLength = 0, maxLength = 16)
    public String getJ_username() {
        return j_username;
    }

    public void setJ_username(String j_username) {
        this.j_username = j_username;
    }
    @Required
    @TextLength (minLength = 0, maxLength = 16)
    public String getJ_password() {
        return j_password;
    }

    public void setJ_password(String j_password) {
        this.j_password = j_password;
    }
}
