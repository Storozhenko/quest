package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.GetListHQLCommand;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.dto.UserDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersListService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Users> getUsers() throws Exception{
        List<Users> users = new GetListCommand<List<Users>>(new Users()).execute(hibernateTemplate);
        return users;
    }
}
