package com.sam.quest.web.controller;

import com.sam.quest.entity.Questions;
import com.sam.quest.service.QuestionService;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.web.validator.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private GeneralValidator questionValidator;
    @Autowired
    private QuestionService questionService;
    private List<String> typeList;

    @RequestMapping("/**/addQuestion")
    public String startInit(HttpSession session, ModelMap modelMap) {
                modelMap.addAttribute("question", new QuestionDTO());
        modelMap.addAttribute("types", typeList);
        return "addQuestion";
    }

    @RequestMapping("/{role}/addQuestionAction")
    public String addQuestion(HttpSession session, ModelMap modelMap, @PathVariable("role") String role,
                              @ModelAttribute("question")QuestionDTO question, BindingResult result) {
        questionValidator.validate(question, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("types", typeList);
            return "addQuestion";
        }
        Questions newQuestion = new Questions();
        try {
            questionService.addQuestion(question, typeList, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("option", new OptionDTO());
        int qNum = (Integer)session.getAttribute("questionNum");
        qNum++;
        session.setAttribute("questionNum", qNum);
        if (question.getQuestionType().equals(typeList.get(0))) {
            return "redirect:/" + role + "/addQuestion";
        } else {
            return "redirect:/" + role + "/addOption";
        }
    }

    @RequestMapping("/{role}/deleteQuestionAction")
    public String deleteQuestion(@RequestParam(value="questionId", required=true) String questionId, HttpSession session,
                                 @PathVariable("role") String role) {
        try {
            if (role.equals("admin")) {
                questionService.deleteQuestion(Long.valueOf(questionId));
            } else {
                questionService.deleteUserQuestion(Long.valueOf(questionId));
            }
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/" + role + "/formQuestions?formId=" + session.getAttribute("formId");
    }

    @RequestMapping("/{role}/updateQuestionAction")
    public String updateQuestion(HttpSession session, @PathVariable("role") String role,
                                 @ModelAttribute("question")QuestionDTO question) {
        try {
            if (role.equals("admin")) {
                questionService.updateQuestion(question);
            } else {
                questionService.updateUserQuestion(question);
            }

        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/" + role + "/formQuestions?formId=" + session.getAttribute("formId");
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
