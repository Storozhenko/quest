package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.GetListHQLCommand;
import com.sam.quest.dto.AnswFormDTO;
import com.sam.quest.dto.AnswQuestionDTO;
import com.sam.quest.entity.AnswForms;
import com.sam.quest.entity.AnswQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswFormsListService {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    private static long id;

    public List<AnswFormDTO> getAnswForms() throws Exception{
        List<AnswFormDTO> answFormsDTO = new ArrayList<AnswFormDTO>();
        List<AnswForms> answForms = new GetListCommand<List<AnswForms>>(new AnswForms()).execute(hibernateTemplate);
        for (AnswForms af: answForms) {
            AnswFormDTO afDTO = new AnswFormDTO();
            afDTO.setAnswId(af.getAnswId());
            afDTO.setFormName(af.getFormId().getFormName());
            afDTO.setFormDescr(af.getFormId().getFormDescr());
            afDTO.setUsername(af.getUserId().getUsername());
            afDTO.setAnswDatetime(af.getAnswDatetime());
            answFormsDTO.add(afDTO);
        }
        return answFormsDTO;
    }
    public List<AnswQuestionDTO> getAnswQuestions(long answId) throws Exception{
        List<AnswQuestionDTO> answQuestDTO = new ArrayList<AnswQuestionDTO>();
        List<AnswQuestions> answQuests = new GetListHQLCommand<List<AnswQuestions>>(
                "from AnswQuestions where answId = '" + answId + "'").execute(hibernateTemplate);
        for (AnswQuestions aq: answQuests) {
            long questId = aq.getQuestionId().getQuestionId().longValue();
            if (questId != id) {
                AnswQuestionDTO aqDTO = new AnswQuestionDTO();
                aqDTO.setQuestionName(aq.getQuestionId().getQuestionName());
                aqDTO.setQuestionDescr(aq.getQuestionId().getQuestionDescr());
                List <String> options = new GetListHQLCommand<List<String>>(
                        "select userAnswer from AnswQuestions where answId = " + answId +
                        " and questionId = '" + aq.getQuestionId().getQuestionId() + "'").execute(hibernateTemplate);
                aqDTO.setUserAnswer(options);
                answQuestDTO.add(aqDTO);
                id = questId;
            }
        }
        id = 0;
        return answQuestDTO;
    }
}
