package com.sam.quest.web.controller.autowired;

import com.sam.quest.service.AddFormService;
import com.sam.quest.dto.FormDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.web.validator.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class AddFormController {
    @Autowired
    private FormValidator formValidator;
    @Autowired
    private AddFormService addFormService;

    @RequestMapping("/**/addForm")
    public String startInit(HttpSession session, ModelMap modelMap) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return "addForm";
    }

    @RequestMapping("/**/addFormAction")
    public String addForm(HttpSession session, ModelMap modelMap, @ModelAttribute("form")FormDTO form, BindingResult result) {
        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "addForm";
        }
        try {
            addFormService.addForm(form, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("question", new QuestionDTO());
        return "redirect:/addQuestion";
    }
}
