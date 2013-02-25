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
    private TransactionalPerformer trPerformer;

    public Users checkUser(LoginDTO loginForm) throws Exception{
        Users user = (Users)trPerformer.executeCommand(new FindCommand("Select * from Users where username = '" + loginForm.getUsername() + "'"));
        return user;
    }

    public void setTrPerformer(TransactionalPerformer trPerformer) {
        this.trPerformer = trPerformer;
    }
}
