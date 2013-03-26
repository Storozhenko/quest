package com.sam.quest.service;

import com.sam.quest.command.*;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.dto.UserDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.entity.QuestionsData;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addUser(UserDTO userDTO) throws Exception{
        Users user = new Users();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserType(userDTO.getUserType());
        user.setUserLang(userDTO.getUserLang());
        new InsertCommand(user).execute(hibernateTemplate);
    }

    public void deleteUser(long userId) throws Exception{
        Users user = new Users();
        user.setUserId(userId);
        new DeleteCommand(user).execute(hibernateTemplate);
    }

    public void updateUser(UserDTO userDTO) throws Exception{
        Users user = new Users();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserType(userDTO.getUserType());
        user.setUserLang(userDTO.getUserLang());
        new UpdateCommand(user).execute(hibernateTemplate);
    }
}
