package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.entity.Forms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormsListService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Forms> getForms() throws Exception{
        //List<FormDTO> formsDTO = new ArrayList<FormDTO>();
        List<Forms> forms = new GetListCommand<List<Forms>>(new Forms()).execute(hibernateTemplate);
        return forms;
    }
}
