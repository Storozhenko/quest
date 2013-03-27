package com.sam.quest.service;

import com.sam.quest.command.DeleteCommand;
import com.sam.quest.command.InsertCommand;
import com.sam.quest.command.UpdateCommand;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.entity.AnswForms;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class AnswFormService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void deleteAnswForm(long answId) throws Exception{
        AnswForms delForm = new AnswForms();
        delForm.setAnswId(answId);
        new DeleteCommand(delForm).execute(hibernateTemplate);
    }
}
