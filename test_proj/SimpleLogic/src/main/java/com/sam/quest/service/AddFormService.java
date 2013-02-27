package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.InsertCommand;
import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AddFormService {
    private TransactionalPerformer<Forms> trPerformer;

    public Forms addForm(FormDTO form) throws Exception{
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Forms newForm = new Forms();
        newForm.setUserId(user);
        newForm.setFormName(form.getFormName());
        newForm.setFormDescr(form.getFormDescr());
        newForm.setFormDate(new Date(System.currentTimeMillis()));
        trPerformer.executeCommand(new InsertCommand(newForm));
        return newForm;
    }

    public void setTrPerformer(TransactionalPerformer trPerformer) {
        this.trPerformer = trPerformer;
    }
}
