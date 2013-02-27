package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.*;
import com.sam.quest.service.FillFormService;
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
    @Autowired
    private FillFormService fillFormService;

    @RequestMapping("/**/fillForm")
    public String startInit(@RequestParam(value="formId", required=true) String formId, HttpSession session, ModelMap modelMap) {
        try {
            fillFormService.initForm(formId, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("answQuestion", new AnswQuestionDTO());
        return "fillForm";
    }

    @RequestMapping("/**/addAnswerAction")
    public String addAnswer(HttpSession session, ModelMap modelMap, @ModelAttribute("answQuestion")AnswQuestionDTO answQuestion,
                            BindingResult result) {
        answerValidator.validate(answQuestion, result);
        if (result.hasErrors()) {
            return "fillForm";
        }
        String view;
        try {
            view = fillFormService.fillForm(answQuestion, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("answQuestion", new AnswQuestionDTO());
        return view;
    }
}
