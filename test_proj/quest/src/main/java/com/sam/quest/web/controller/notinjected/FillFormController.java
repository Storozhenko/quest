package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.*;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.dto.AnswQuestionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class FillFormController {

    @RequestMapping("/**/fillForm")
    public String startInit(@RequestParam(value="formId", required=true) String formId, HttpSession session, ModelMap modelMap) {
        MultiService <Forms> servF = new ServiceImpl<Forms>();
        MultiService <AnswForms> servAF = new ServiceImpl<AnswForms>();
        MultiService <Questions> servQ = new ServiceImpl<Questions>();
        MultiService <QuestionsData> servQD;
        List<Questions> questList = null;
        List<QuestionsData> questDataList = null;
        Questions currentQuest;
        try {
            questList = servQ.listHQLRecord("from Questions where form_id = '" + formId + "' ");
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        try {
            currentQuest = questList.get(0);
            servQD = new ServiceImpl<QuestionsData>();
            questDataList = servQD.listHQLRecord("from QuestionsData where question_id = '"
                    + currentQuest.getQuestionId().toString() + "' ");
        } catch (Exception e) {
            session.setAttribute("error", "There are no questions in the form or no options in question");
            return "error";
        }
        List <String> options = new ArrayList<String>();
        for (QuestionsData qd : questDataList) {
            options.add(qd.getOptionData());
        }
        Forms form;
        try {
            form = servF.findRecord(Long.valueOf(formId), new Forms());
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        AnswForms af = new AnswForms();
        Users user = new Users();
        user.setUserId((Long)session.getAttribute("userId"));
        af.setUserId(user);
        af.setFormId(form);
        af.setAnswDatetime(new Timestamp(System.currentTimeMillis()));
        try {
            servAF.addRecord(af);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        AnswQuestionDTO answQuestion = new AnswQuestionDTO();
        answQuestion.setQuestionNumber(1);
        //modelMap will be cleared after failed validation
        session.setAttribute("questType", currentQuest.getQuestionType());
        session.setAttribute("questOptions", options);
        session.setAttribute("currentQuest", currentQuest);
        modelMap.addAttribute("answQuestion", answQuestion);
        return "fillForm";
    }

    @RequestMapping("/**/addAnswerAction")
    public String addAnswer(HttpSession session, ModelMap modelMap, @ModelAttribute("answQuestion")AnswQuestionDTO answQuestion) {
        return "fillForm";
    }
}
