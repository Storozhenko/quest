package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.RegistrationDTO;
import com.sam.quest.service.RegistrationService;
import com.sam.quest.web.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationValidator regValidator;
    @Autowired
    private RegistrationService regService;

    @RequestMapping("/registration")
    public String startInit(ModelMap modelMap) {
        modelMap.addAttribute("regForm", new RegistrationDTO());
        return "registration";
    }

    @RequestMapping(value = "/registrationAction", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("regForm") RegistrationDTO regForm, HttpSession session, BindingResult result) {
        regValidator.validate(regForm, result);
        if (result.hasErrors()) {
            return "registration";
        }
        try {
            regService.addUser(regForm);
        } catch (Exception e) {
            session.setAttribute("error", "Duplicate usernames");
            return "error";
        }
        return "redirect:/login";

    }
}
