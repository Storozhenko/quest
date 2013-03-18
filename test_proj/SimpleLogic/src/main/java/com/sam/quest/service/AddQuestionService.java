package com.sam.quest.service;

import com.sam.quest.command.InsertCommand;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AddQuestionService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addQuestion(QuestionDTO question, List<String> typeList, HttpSession session) throws Exception{
        int type = 0;
        for (String u : typeList) {
            type++;
            if (u.equals(question.getQuestionType())) {
                break;
            }
        }
        Questions newQuestion = new Questions();
        newQuestion.setQuestionName(question.getQuestionName());
        newQuestion.setQuestionDescr(question.getQuestionDescr());
        newQuestion.setQuestionType(type);
        newQuestion.setFormId((Forms)session.getAttribute("newForm"));
        new InsertCommand(newQuestion).execute(hibernateTemplate);
        session.setAttribute("newQuestion", newQuestion);
        session.setAttribute("type", type);
    }
}
