package com.sam.quest.service;


import com.sam.quest.command.*;
import com.sam.quest.dto.LoginDTO;
import com.sam.quest.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LoginService {
    private TransactionalPerformer<List<Users>> trPerformer;

    public Users checkUser(LoginDTO loginForm) throws Exception{
        List<Users> users = trPerformer.executeCommand(new FindCommand("from Users where username = '" + loginForm.getUsername() + "'"));
        for (Users u: users) {
            if (u.getUsername().equals(loginForm.getUsername())) {
                return u;
            }
        }
        return null;
    }

    public void setTrPerformer(TransactionalPerformer trPerformer) {
        this.trPerformer = trPerformer;
    }
}
