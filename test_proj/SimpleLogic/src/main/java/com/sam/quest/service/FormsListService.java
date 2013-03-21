package com.sam.quest.service;

import com.sam.quest.command.GetListCommand;
import com.sam.quest.command.GetListHQLCommand;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
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
        List<Forms> forms = new GetListCommand<List<Forms>>(new Forms()).execute(hibernateTemplate);
        return forms;
    }

    public List<QuestionDTO> getFormsQuestions(long formId) throws Exception{
        List<Questions> quests = new GetListHQLCommand<List<Questions>>("from Questions where formId = '" + formId + "'").execute(hibernateTemplate);
        List<QuestionDTO> questsDTO = new ArrayList<QuestionDTO>();
        for (Questions q : quests) {
            QuestionDTO qDTO = new QuestionDTO();
            qDTO.setQuestionId(q.getQuestionId());
            qDTO.setQuestionName(q.getQuestionName());
            qDTO.setQuestionDescr(q.getQuestionDescr());
            qDTO.setQuestionType(q.getQuestionType().toString());
            List <String> options = new GetListHQLCommand<List<String>>("select optionData from QuestionsData where questionId = '" + q.getQuestionId() + "'").execute(hibernateTemplate);
            qDTO.setQuestionOptions(options);
            questsDTO.add(qDTO);
        }
        return questsDTO;
    }
}
