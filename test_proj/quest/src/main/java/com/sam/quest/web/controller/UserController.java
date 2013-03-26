package com.sam.quest.web.controller;

import com.sam.quest.dto.OptionDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Questions;
import com.sam.quest.service.QuestionService;
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
public class UserController {
    @Autowired
    private GeneralValidator userValidator;
    @Autowired
    private QuestionService questionService;
    private List<String> typeList;

    @RequestMapping("/admin/addUser")
    public String startInit(HttpSession session, ModelMap modelMap) {
                modelMap.addAttribute("question", new QuestionDTO());
        modelMap.addAttribute("types", typeList);
        return "addUser";
    }

    @RequestMapping("/admin/addUserAction")
    public String addQuestion(HttpSession session, ModelMap modelMap, @ModelAttribute("question")QuestionDTO question,
                              BindingResult result) {
        userValidator.validate(question, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("types", typeList);
            return "addUser";
        }
        Questions newQuestion = new Questions();
        try {
            questionService.addQuestion(question, typeList, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/admin/users";
    }

    @RequestMapping("/{role}/deleteUserAction")
    public String deleteQuestion(@RequestParam(value="questionId", required=true) String questionId, HttpSession session,
                                 @PathVariable("role") String role) {
        try {
            questionService.deleteQuestion(Long.valueOf(questionId));
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/" + role + "/formQuestions?formId=" + session.getAttribute("formId");
    }

    @RequestMapping("/{role}/updateUserAction")
    public String updateQuestion(@RequestParam(value="questionId", required=true) String questionId, HttpSession session,
                                 @PathVariable("role") String role, @ModelAttribute("question")QuestionDTO question) {
        try {
            questionService.updateQuestion(question);
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
