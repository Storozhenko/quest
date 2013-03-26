package com.sam.quest.service;

import com.sam.quest.command.DeleteCommand;
import com.sam.quest.command.InsertCommand;
import com.sam.quest.command.UpdateCommand;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class FormService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addForm(FormDTO form, HttpSession session) throws Exception{
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Forms newForm = new Forms();
        newForm.setUserId(user);
        newForm.setFormName(form.getFormName());
        newForm.setFormDescr(form.getFormDescr());
        newForm.setFormDate(new Date(System.currentTimeMillis()));
        new InsertCommand(newForm).execute(hibernateTemplate);
        session.setAttribute("newForm", newForm);
        session.setAttribute("questionNum", 0);
    }

    public void updateForm(FormDTO form) throws Exception{
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Forms newForm = new Forms();
        newForm.setFormId(form.getFormId());
        newForm.setUserId(user);
        newForm.setFormName(form.getFormName());
        newForm.setFormDescr(form.getFormDescr());
        newForm.setFormDate(new Date(System.currentTimeMillis()));
        new UpdateCommand(newForm).execute(hibernateTemplate);
    }

    public void deleteForm(String formId) throws Exception{
        Forms delForm = new Forms();
        delForm.setFormId(Long.valueOf(formId));
        new DeleteCommand(delForm).execute(hibernateTemplate);
    }
}