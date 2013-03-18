package com.sam.quest.service;

import com.sam.quest.command.*;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Users checkUser(String username) throws UsernameNotFoundException{
        Users user = null;
        try {
            user = new FindCommand<Users>("from Users where username = '" + username + "'").execute(hibernateTemplate);
        } catch (Exception e) {
            throw new UsernameNotFoundException( username + " not found" );
        }
        return user;
    }
}
