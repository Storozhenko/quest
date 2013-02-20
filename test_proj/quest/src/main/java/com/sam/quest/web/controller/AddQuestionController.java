package com.sam.quest.web.controller;

import com.sam.quest.entity.Questions;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.dto.OptionDTO;
import com.sam.quest.web.dto.QuestionDTO;
import com.sam.quest.web.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddQuestionController {
    @Autowired
    private QuestionValidator questionValidator;
    private List<String> typeList;
    private MessageSource messageSource;

    @RequestMapping("/**/addQuestion")
    public String startInit(HttpSession session, ModelMap modelMap) {
        modelMap.addAttribute("question", new QuestionDTO());
        modelMap.addAttribute("types", typeList);
        return "addQuestion";
    }

    @RequestMapping("/**/addQuestionAction")
    public String addQuestion(HttpSession session, ModelMap modelMap, @ModelAttribute("question")QuestionDTO question, BindingResult result) {
        questionValidator.validate(question, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("types", typeList);
            return "addQuestion";
        }
        int type = 0;
        for (String u : typeList) {
            type++;
            if (u.equals(question.getQuestionType())) {
                session.setAttribute("typeTxt", u);
                break;
            }
        }
        Questions newQuestion = new Questions();
        newQuestion.setQuestionName(question.getQuestionName());
        newQuestion.setQuestionType(type);
        newQuestion.setQuestionDescr(question.getQuestionDescr());
        MultiService<Questions> servQuest = new ServiceImpl<Questions>();
        try {
            servQuest.addRecord(newQuestion);
            List<Questions> list = servQuest.listRecord(new Questions());
            for (Questions q : list) {
                if (q.getQuestionName().equals(question.getQuestionName()))
                    session.setAttribute("questionId", q.getQuestionId());
            }
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }

        session.setAttribute("type", type);
        modelMap.addAttribute("option", new OptionDTO());
        return "redirect:/addOption";
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }


}
