package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.AnswerDTO;
import com.sam.quest.service.FillFormService;
import com.sam.quest.web.validator.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class FillFormController {
    @Autowired
    private GeneralValidator answerValidator;
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
        modelMap.addAttribute("answQuestion", new AnswerDTO());
        return "fillForm";
    }

    @RequestMapping("/**/addAnswerAction")
    public String addAnswer(HttpSession session, ModelMap modelMap, @ModelAttribute("answQuestion")AnswerDTO answQuestion,
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
        modelMap.addAttribute("answQuestion", new AnswerDTO());
        return view;
    }
}
