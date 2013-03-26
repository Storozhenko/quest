package com.sam.quest.dto;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.TextLength;
import com.sam.quest.dto.annotations.Validatable;

@Validatable
public class UserDTO {
    private String userId;
    private String username;
    private String password;
    private String userType;
    private String userLang;


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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }
    @Required
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
