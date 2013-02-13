package com.sam.quest.web.controller;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.LoginForm;
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
public class LoginController {
    private String message;
    private static Map<String, Users> usersMap = new HashMap<String, Users>();
    @Autowired
    private LoginValidator loginValidator;

    public void setMessage(String message) {
        this.message = message;
    }

    @RequestMapping("/login")
    public String startRedirect(HttpSession session, ModelMap modelMap) {
        message = "Hello, Spring 3.0!";
        LoginForm loginForm = new LoginForm();
        session.setAttribute("message", message);
        modelMap.addAttribute("loginForm", loginForm);
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String checkUser(HttpSession session, LoginForm loginForm, BindingResult result) {
        loginValidator.validate(loginForm, result);
        if (result.hasErrors()) {
            return "login";
        }
        MultiService <Users> serv = new ServiceImpl<Users>();
        List<Users> users = serv.listRecord(new Users());
        usersMap.clear();
        for (Users u: users) {
            String userKey = u.getUsername();
            usersMap.put(userKey, u);
        }
        Users user = usersMap.get(loginForm.getUsername());
        if(user != null) {
            if (user.getPassword().equals(loginForm.getPassword())) {
                session.setAttribute("username", loginForm.getUsername());
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
