package com.sam.quest.web.controller;

import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.service.AddQuestionService;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.web.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AddQuestionService addQuestionService;
    private List<String> typeList;

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
        Questions newQuestion = new Questions();
        try {
            addQuestionService.addQuestion(question, typeList, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("option", new OptionDTO());
        return "redirect:/addOption";
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
