package com.sam.quest.service;

import com.sam.quest.command.InsertCommand;
import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.entity.QuestionsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AddOptionService {
    @Autowired
    private TransactionalPerformer<QuestionsData> trPerformer;

    public void addOption(OptionDTO option, HttpSession session) throws Exception{
        QuestionsData newQD = new QuestionsData();
        newQD.setQuestionId((Questions)session.getAttribute("newQuestion"));
        newQD.setOptionData(option.getOptionData());
        newQD.setQuestionOption(option.getOptionNum());
        trPerformer.executeCommand(new InsertCommand(newQD));
    }
}