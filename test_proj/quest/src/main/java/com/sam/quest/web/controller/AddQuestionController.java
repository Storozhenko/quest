package com.sam.quest.web.controller;

import com.sam.quest.web.dto.QuestionDTO;
import com.sam.quest.web.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddQuestionController {
    @Autowired
    private QuestionValidator questionValidator;
    private List<String> typeList;

    @RequestMapping("/**/addQuestion")
    public String startInit(HttpSession session, ModelMap modelMap) {
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        modelMap.addAttribute("types", typeList);
        return "addQuestion";
    }

    @RequestMapping("/**/addQuestionAction")
    public String addQuestion(HttpSession session, @ModelAttribute("question")QuestionDTO question, BindingResult result) {
       // questionValidator = new QuestionValidator();
        questionValidator.validate(question, result);
        if (result.hasErrors()) {
            return "addQuestion";
        }
        return "addQuestion";
    }

    @RequestMapping("/**/addOptionAction")
    public String addOption(HttpSession session, @ModelAttribute("question")QuestionDTO question, BindingResult result) {
        // questionValidator = new QuestionValidator();
        questionValidator.validate(question, result);
        if (result.hasErrors()) {
            return "addQuestion";
        }
        return "addQuestion";
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
