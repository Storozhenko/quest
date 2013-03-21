package com.sam.quest.web.controller.autowired;

import com.sam.quest.service.FormService;
import com.sam.quest.dto.FormDTO;
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

@Controller
public class FormController {
    @Autowired
    private GeneralValidator formValidator;
    @Autowired
    private FormService formService;

    @RequestMapping("/{role}/addForm")
    public String startInit(ModelMap modelMap, @PathVariable("role") String role) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return "addForm";
    }

    @RequestMapping("/{role}/addFormAction")
    public String addForm(HttpSession session, ModelMap modelMap, @PathVariable("role") String role,
                          @ModelAttribute("form")FormDTO form, BindingResult result) {
        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "addForm";
        }
        try {
            formService.addForm(form, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("question", new QuestionDTO());
        session.setAttribute("questionNum", 1);
        return "redirect:/" + role + "/addQuestion";
    }

    @RequestMapping("/admin/updateFormAction")
    public String updateForm(HttpSession session, ModelMap modelMap, @ModelAttribute("form")FormDTO form,
                             BindingResult result) {
        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "addForm";
        }
        try {
            formService.updateForm(form);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/admin/forms";
    }
    @RequestMapping("/admin/deleteFormAction")
    public String startInit(@RequestParam(value="formId", required=true) String formId, HttpSession session, ModelMap modelMap) {
        try {
            formService.deleteForm(formId);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/admin/forms";
    }
}
