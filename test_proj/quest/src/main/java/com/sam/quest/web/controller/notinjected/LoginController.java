package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Users;
import com.sam.quest.service.LoginService;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ImplService;
import com.sam.quest.dto.LoginDTO;
import com.sam.quest.web.validator.LoginValidator;
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
public class LoginController {
    @Autowired
    private LoginValidator loginValidator;

    @RequestMapping("/login")
    public String startInit(HttpSession session, ModelMap modelMap) {
        session.setAttribute("message", "message");
        modelMap.addAttribute("loginForm", new LoginDTO());
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String checkUser(HttpSession session, @ModelAttribute("loginForm")LoginDTO loginForm, BindingResult result) {
        loginValidator.validate(loginForm, result);
        if (result.hasErrors()) {
            return "login";
        }
        Users user = null;
        try {
            user = new LoginService().checkUser(loginForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user != null) {
            if (user.getPassword().equals(loginForm.getPassword())) {
                session.setAttribute("username", user.getUsername());
                session.setAttribute("userId", user.getUserId());
                if (user.getUserType().equals("admin"))
                    return "admin/adminMain";
                else
                    return "user/userMain";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }
}
