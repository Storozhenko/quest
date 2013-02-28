package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    @RequestMapping("/**/main")
    public String startInit(HttpSession session, HttpServletRequest request) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", user.getUsername());
        return request.getPathInfo();
    }
}
