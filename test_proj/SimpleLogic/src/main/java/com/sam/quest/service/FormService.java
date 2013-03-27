package com.sam.quest.service;

import com.sam.quest.command.DeleteCommand;
import com.sam.quest.command.FindCommand;
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

    public void updateForm(FormDTO formDTO) throws Exception{
        Forms checkForm = new FindCommand<Forms>(formDTO.getFormId(), new Forms()).execute(hibernateTemplate);
        Forms form = new Forms();
        form.setFormId(formDTO.getFormId());
        form.setUserId(checkForm.getUserId());
        form.setFormName(formDTO.getFormName());
        form.setFormDescr(formDTO.getFormDescr());
        form.setFormDate(new Date(System.currentTimeMillis()));
        new UpdateCommand(form).execute(hibernateTemplate);
    }

    public void deleteForm(long formId) throws Exception{
        Forms delForm = new Forms();
        delForm.setFormId(formId);
        new DeleteCommand(delForm).execute(hibernateTemplate);
    }

    public void updateUserForm(FormDTO formDTO) throws Exception{
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Forms checkForm = new FindCommand<Forms>(formDTO.getFormId(), new Forms()).execute(hibernateTemplate);
        if (checkForm.getUserId().getUserId().longValue() == user.getUserId()) {
            Forms form = new Forms();
            form.setFormId(formDTO.getFormId());
            form.setUserId(user);
            form.setFormName(formDTO.getFormName());
            form.setFormDescr(formDTO.getFormDescr());
            form.setFormDate(new Date(System.currentTimeMillis()));
            new UpdateCommand(form).execute(hibernateTemplate);
        } else {
            throw new Exception("Access denied");
        }
    }

    public void deleteUserForm(long formId) throws Exception{
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Forms checkForm = new FindCommand<Forms>(formId, new Forms()).execute(hibernateTemplate);
        if (checkForm.getUserId().getUserId().longValue() == user.getUserId()) {
            Forms delForm = new Forms();
            delForm.setFormId(formId);
            new DeleteCommand(delForm).execute(hibernateTemplate);
        } else {
            throw new Exception("Access denied");
        }
    }
}
