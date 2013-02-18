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
    private String type1;
    private String type2;
    private String type3;

    @RequestMapping("/**/addQuestion")
    public String startInit(HttpSession session, ModelMap modelMap) {
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        List <String> typeList = new ArrayList<String>();
        typeList.add(type1);
        typeList.add(type2);
        typeList.add(type3);
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

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
}
