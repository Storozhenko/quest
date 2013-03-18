package com.sam.quest.service;

import com.sam.quest.command.FindCommand;
import com.sam.quest.command.GetListHQLCommand;
import com.sam.quest.command.InsertCommand;
import com.sam.quest.dto.AnswerDTO;
import com.sam.quest.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class FillFormService {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    private static List<Questions> questList;

    public void initForm(String formId, HttpSession session) throws Exception{
        questList = new GetListHQLCommand<List<Questions>>(
                "from Questions where formId = '" + formId + "' ").execute(hibernateTemplate);
        Questions currentQuest = questList.get(0);
        List <QuestionsData> questDataList = new GetListHQLCommand<List <QuestionsData>>(
                "from QuestionsData where questionId = '" + currentQuest.getQuestionId().toString() + "' ").execute(hibernateTemplate);
        List <String> options = new ArrayList<String>();
        for (QuestionsData qd : questDataList) {
            options.add(qd.getOptionData());
        }
        Forms form = new FindCommand<Forms>(Long.valueOf(formId), new Forms()).execute(hibernateTemplate);
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AnswForms newAnswForm = new AnswForms();
        newAnswForm.setUserId(user);
        newAnswForm.setFormId(form);
        newAnswForm.setAnswDatetime(new Timestamp(System.currentTimeMillis()));
        new InsertCommand<AnswForms>(newAnswForm).execute(hibernateTemplate);
        session.setAttribute("questOptions", options);
        session.setAttribute("questNum", 1);
        session.setAttribute("currentQuest", currentQuest);
        session.setAttribute("questType", currentQuest.getQuestionType());
        session.setAttribute("answForm", newAnswForm);
    }

    public String fillForm(AnswerDTO answQuestion, HttpSession session) throws Exception{
        String [] answers = answQuestion.getQuestionAnswer();
        AnswQuestions newAnswQuest = new AnswQuestions();
        newAnswQuest.setAnswId((AnswForms)session.getAttribute("answForm"));
        newAnswQuest.setQuestionId((Questions)session.getAttribute("currentQuest"));
        for (int i = 0; i < answQuestion.getQuestionAnswer().length; i++) {
            newAnswQuest.setUserAnswer(answers[i]);
            new InsertCommand(newAnswQuest).execute(hibernateTemplate);
        }
        int num = (Integer)session.getAttribute("questNum") + 1;
        if (questList.size() < num) {
            return "success";
        }
        Questions currentQuest = questList.get(num - 1);
        List <QuestionsData> questDataList = new GetListHQLCommand<List <QuestionsData>>(
                "from QuestionsData where questionId = '" + currentQuest.getQuestionId().toString() + "' ").execute(hibernateTemplate);
        List <String> options = new ArrayList<String>();
        for (QuestionsData qd : questDataList) {
            options.add(qd.getOptionData());
        }
        session.setAttribute("questOptions", options);
        session.setAttribute("questNum", num);
        session.setAttribute("currentQuest", currentQuest);
        session.setAttribute("questType", currentQuest.getQuestionType());
        return "fillForm";
    }
}
