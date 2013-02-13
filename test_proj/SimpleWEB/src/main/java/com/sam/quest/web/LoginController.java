package com.sam.quest.web;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String startRedirect(Map<String, Object> session) {
        message = "Hello, Spring 3.0!";
        LoginForm loginForm = new LoginForm();
        session.put("message", message);
        session.put("loginForm", loginForm);
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String checkUser(Map<String, Object> session, LoginForm loginForm, BindingResult result) {
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
        String userKey = loginForm.getUsername();
        Users user = (Users)usersMap.get(loginForm.getUsername());
        if(user != null) {
            if (user.getPassword().equals(loginForm.getPassword())) {
                session.put("user", user);
                return "main";
            } else {
                //addFieldError("password", "Invalid password");
                return "login";
            }
        } else {
            //addFieldError("username", "Invalid username");
            return "login";
        }

    }
}
