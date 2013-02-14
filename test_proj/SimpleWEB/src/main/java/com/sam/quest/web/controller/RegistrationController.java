package com.sam.quest.web.controller;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.RegistrationForm;
import com.sam.quest.web.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private LoginValidator loginValidator;

    @RequestMapping("/registration")
    public String startRedirect(HttpSession session, ModelMap modelMap) {
        RegistrationForm regForm = new RegistrationForm();
        modelMap.addAttribute("regForm", regForm);
        return "registration";
    }

    @RequestMapping(value = "/registrationAction", method = RequestMethod.POST)
    public String checkUser(HttpSession session, RegistrationForm regForm, BindingResult result) {
        loginValidator.validate(regForm, result);
        if (result.hasErrors()) {
            return "registration";
        }
        Users user = new Users();
        MultiService <Users> serv = new ServiceImpl<Users>();
        try {
            serv.addRecord(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "registration";
        }
        return "login";

    }
}
