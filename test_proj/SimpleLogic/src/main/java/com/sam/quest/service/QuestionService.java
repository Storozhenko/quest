package com.sam.quest.service;

import com.sam.quest.command.*;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.entity.QuestionsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class QuestionService {
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

    public void deleteQuestion(long questId) throws Exception{
        Questions quest = new Questions();
        quest.setQuestionId(questId);
        new DeleteCommand(quest).execute(hibernateTemplate);
    }

    public void updateQuestion(QuestionDTO questDTO) throws Exception{
        Questions quest = new FindCommand<Questions>(questDTO.getQuestionId(), new Questions()).execute(hibernateTemplate);
        quest.setQuestionName(questDTO.getQuestionName());
        quest.setQuestionDescr(questDTO.getQuestionDescr());
        new UpdateCommand(quest).execute(hibernateTemplate);
        String[] options = questDTO.getQuestionOptionsString().split(", ");
        List<QuestionsData> listQData = new GetListHQLCommand<List<QuestionsData>>(
                "from QuestionsData where questionId = '" + questDTO.getQuestionId() + "'").execute(hibernateTemplate);
        if ((listQData.size() != options.length) && (listQData.size() > 0)) {
            throw new Exception("Invalid number of options");
        } else {
            int i = 0;
            for (QuestionsData qData : listQData) {
                qData.setOptionData(options[i]);
                new UpdateCommand(qData).execute(hibernateTemplate);
                i++;
            }
        }


    }
}
