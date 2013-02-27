package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.*;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ImplService;
import com.sam.quest.dto.AnswQuestionDTO;
import com.sam.quest.web.validator.AnswerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FillFormController {
    @Autowired
    private AnswerValidator answerValidator;

    @RequestMapping("/**/fillForm")
    public String startInit(@RequestParam(value="formId", required=true) String formId, HttpSession session, ModelMap modelMap) {
        MultiService <Forms> servF = new ImplService<Forms>();
        MultiService <AnswForms> servAF = new ImplService<AnswForms>();
        MultiService <Questions> servQ = new ImplService<Questions>();
        MultiService <QuestionsData> servQD;
        List <QuestionsData> questDataList = null;
        List <Questions> questList;
        Questions currentQuest;
        try {
            questList = servQ.listHQLRecord("from Questions where form_id = '" + formId + "' ");
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        try {
            currentQuest = questList.get(0);
            servQD = new ImplService<QuestionsData>();
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
            servAF.insertRecord(af);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        AnswQuestionDTO answQuestion = new AnswQuestionDTO();
        //modelMap will be cleared after failed validation
        session.setAttribute("questList", questList);
        session.setAttribute("questType", currentQuest.getQuestionType());
        session.setAttribute("questOptions", options);
        session.setAttribute("questNum", 1);
        session.setAttribute("currentQuest", currentQuest);
        session.setAttribute("answForm", af);
        modelMap.addAttribute("answQuestion", answQuestion);
        return "fillForm";
    }

    @RequestMapping("/**/addAnswerAction")
    public String addAnswer(HttpSession session, ModelMap modelMap, @ModelAttribute("answQuestion")AnswQuestionDTO answQuestion,
                            BindingResult result) {
        answerValidator.validate(answQuestion, result);
        if (result.hasErrors()) {
            return "fillForm";
        }
        List <Questions> questList = (List <Questions>)session.getAttribute("questList");
        MultiService <AnswQuestions> servAQ = new ImplService<AnswQuestions>();
        String [] answers = answQuestion.getQuestionAnswer();
        AnswQuestions newAQ = new AnswQuestions();
        newAQ.setAnswId((AnswForms)session.getAttribute("answForm"));
        newAQ.setQuestionId((Questions)session.getAttribute("currentQuest"));
        for (int i = 0; i < answQuestion.getQuestionAnswer().length; i++) {
            newAQ.setUserAnswer(answers[i]);
            try {
                servAQ.insertRecord(newAQ);
            } catch (Exception e) {
                session.setAttribute("error", e.getMessage());
                return "error";
            }
        }
        Questions currentQuest;
        MultiService <QuestionsData> servQD;
        List<QuestionsData> questDataList = null;
        int num = (Integer)session.getAttribute("questNum") + 1;
        if (questList.size() < num) {
            return "success";
        }
        try {
            currentQuest = questList.get(num - 1);
            servQD = new ImplService<QuestionsData>();
            questDataList = servQD.listHQLRecord("from QuestionsData where question_id = '"
                    + currentQuest.getQuestionId().toString() + "' ");
        }
        catch (Exception e) {
            session.setAttribute("error", "There are no questions in the form or no options in question");
            return "error";
        }
        List <String> options = new ArrayList<String>();
        for (QuestionsData qd : questDataList) {
            options.add(qd.getOptionData());
        }
        AnswQuestionDTO newAnswQuestion = new AnswQuestionDTO();
        session.setAttribute("questType", currentQuest.getQuestionType());
        session.setAttribute("questOptions", options);
        session.setAttribute("currentQuest", currentQuest);
        session.setAttribute("questNum", num);
        modelMap.addAttribute("answQuestion", newAnswQuestion);
        return "fillForm";
    }
}
