package com.sam.quest.service;

import com.sam.quest.command.*;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private TransactionalPerformer<List<Users>> trPerformer;

    public Users checkUser(String username) throws UsernameNotFoundException{
        List<Users> users = null;
        try {
            users = trPerformer.executeCommand(new FindCommand("from Users where username = '" + username + "'"));
        } catch (Exception e) {
            throw new UsernameNotFoundException( username + " not found" );
        }
        for (Users u: users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
