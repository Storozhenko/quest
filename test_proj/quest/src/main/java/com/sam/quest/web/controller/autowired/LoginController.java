package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Users;
import com.sam.quest.service.LoginService;
import com.sam.quest.web.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginValidator loginValidator;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String startInit() {
        //modelMap.addAttribute("loginForm", new LoginDTO());
        return "login";
    }

    @RequestMapping(value = "/loginAction")
    public String checkUser(HttpSession session) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getUserId());
            if (user.getUserType().equals("ROLE_ADMIN")) {
                session.setAttribute("role", "ROLE_ADMIN");
                return "admin/main";
            }
            else {
                session.setAttribute("role", "ROLE_USER");
                return "user/main";
            }
        } else {
            return "login";
        }
    }
}
