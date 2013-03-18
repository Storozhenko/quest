package com.sam.quest.service;

import com.sam.quest.command.InsertCommand;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.entity.Questions;
import com.sam.quest.entity.QuestionsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AddOptionService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addOption(OptionDTO option, HttpSession session) throws Exception{
        QuestionsData newQD = new QuestionsData();
        newQD.setQuestionId((Questions)session.getAttribute("newQuestion"));
        newQD.setOptionData(option.getOptionData());
        newQD.setQuestionOption(option.getOptionNum());
        new InsertCommand(newQD).execute(hibernateTemplate);
    }
}
