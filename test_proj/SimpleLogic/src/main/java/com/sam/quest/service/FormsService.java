package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.entity.Forms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormsService {
    @Autowired
    private TransactionalPerformer<List<Forms>> trPerformer;

    public List<Forms> getForms() throws Exception{
        List<FormDTO> formsDTO = new ArrayList<FormDTO>();
        List<Forms> forms = trPerformer.executeCommand(new GetListCommand<List<Forms>>(new Forms()));
        for (Forms f: forms) {
            FormDTO form = new FormDTO(f.getFormName(), f.getFormDescr());
            formsDTO.add(form);
        }
        return forms;
    }
}
