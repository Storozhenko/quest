package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    @RequestMapping("/{role}/mainFirst")
    public String startInit(HttpSession session, HttpServletRequest request, @PathVariable("role") String role) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", user.getUsername());
        if (user.getUserLang().equals(""))
            return "redirect:/" + role + "/main";
        else
            return "redirect:/" + role + "/main?locale=" + user.getUserLang();
    }

    @RequestMapping("/**/main")
    public String mainPage(HttpSession session, HttpServletRequest request) {
        return request.getPathInfo();
    }
}
