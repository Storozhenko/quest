package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.LoginDTO;
import com.sam.quest.web.validator.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @Autowired
    private GeneralValidator <LoginDTO> loginValidator;

    @RequestMapping("/login")
    public String startInit(ModelMap modelMap) {
        modelMap.addAttribute("loginForm", new LoginDTO());
        return "login";
    }

    @RequestMapping(value = "/loginAction")
    public String checkUser(@ModelAttribute("loginForm") LoginDTO loginForm, BindingResult result) {
        loginValidator.validate(loginForm, result);
        if (result.hasErrors()) {
            return "login";
        }
        return "forward:/j_spring_security_check";
    }
}
