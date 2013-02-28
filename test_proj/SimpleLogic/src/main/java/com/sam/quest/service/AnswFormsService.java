package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.GetListHQLCommand;
import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.dto.AnswFormDTO;
import com.sam.quest.dto.AnswQuestionDTO;
import com.sam.quest.entity.AnswForms;
import com.sam.quest.entity.AnswQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswFormsService {
    @Autowired
    private TransactionalPerformer trPerformer;
    private static long id;

    public List<AnswFormDTO> getAnswForms() throws Exception{
        List<AnswFormDTO> answFormsDTO = new ArrayList<AnswFormDTO>();
        List<AnswForms> answForms = (List<AnswForms>)trPerformer.executeCommand(new GetListCommand<List<AnswForms>>(new AnswForms()));
        for (AnswForms af: answForms) {
            AnswFormDTO afDTO = new AnswFormDTO();
            afDTO.setAnswId(af.getAnswId());
            afDTO.setFormName(af.getFormId().getFormName());
            afDTO.setFormDescr(af.getFormId().getFormDescr());
            afDTO.setUsername(af.getUserId().getUsername());
            afDTO.setAnswDatetime(af.getAnswDatetime());
            answFormsDTO.add(afDTO);
        }
        id = 0;
        return answFormsDTO;
    }
    public List<AnswQuestionDTO> getAnswQuestions(String answId) throws Exception{
        List<AnswQuestionDTO> answQuestDTO = new ArrayList<AnswQuestionDTO>();
        List<AnswQuestions> answQuests = (List<AnswQuestions>)trPerformer.executeCommand(new GetListCommand<List<AnswQuestions>>(new AnswQuestions()));
        for (AnswQuestions aq: answQuests) {
            if (aq.getAnswId().getAnswId() == Long.valueOf(answId).longValue()) {
                long questId = aq.getQuestionId().getQuestionId().longValue();
                if (questId != id) {
                    AnswQuestionDTO aqDTO = new AnswQuestionDTO();
                    aqDTO.setQuestionName(aq.getQuestionId().getQuestionName());
                    List <String> options = (List<String>)trPerformer.executeCommand(new GetListHQLCommand(
                            "select aq.userAnswer from AnswQuestions aq where aq.answId = '" + answId + "' and aq.questionId = '" + aq.getQuestionId().getQuestionId() + "'"));
                    aqDTO.setUserAnswer(options);
                    answQuestDTO.add(aqDTO);
                    id = questId;
                }
            }
        }
        return answQuestDTO;
    }
}
