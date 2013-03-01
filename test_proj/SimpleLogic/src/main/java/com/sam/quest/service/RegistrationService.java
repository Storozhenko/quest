package com.sam.quest.service;

import com.sam.quest.command.InsertCommand;
import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.dto.RegistrationDTO;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private TransactionalPerformer<Users> trPerformer;

    public void addUser(RegistrationDTO regForm) throws Exception{
        Users newUser = new Users();
        newUser.setUsername(regForm.getUsername());
        newUser.setUserType("ROLE_USER");
        newUser.setPassword(regForm.getPassword());
        newUser.setUserLang(regForm.getLanguage());
        trPerformer.executeCommand(new InsertCommand(newUser));
    }
}
