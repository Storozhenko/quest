package com.sam.quest.web.controller;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.LoginForm;
import com.sam.quest.web.form.RegistrationForm;
import com.sam.quest.web.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationValidator regValidator;

    @RequestMapping("/registration")
    public String regRedirect(ModelMap modelMap) {
        modelMap.addAttribute("regForm", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registrationAction", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("regForm") RegistrationForm regForm, BindingResult result, ModelMap modelMap) {
        regValidator.validate(regForm, result);
        if (result.hasErrors()) {
            return "registration";
        }
        Users user = new Users();
        user.setUsername(regForm.getUsername());
        user.setPassword(regForm.getPassword());
        user.setUserType("user");
        user.setUserLang(regForm.getLanguage());
        MultiService <Users> serv = new ServiceImpl<Users>();
        try {
            serv.addRecord(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "registration";
        }
        return "redirect:/login";

    }
}
