package com.sam.quest.web.controller.notinjected;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RolesController {/*
    @RequestMapping("/**")
    public String allCheck(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("role").equals("ROLE_ADMIN") || session.getAttribute("role").equals("ROLE_USER"))
            return request.getRequestURI();
        else
            return "redirect:/login";
    }
    @RequestMapping("/admin/**")
    public String adminCheck(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("role").equals("ROLE_ADMIN"))
            return request.getRequestURI();
        else
            return "redirect:/login";
    }
    @RequestMapping("/user/**")
    public String userCheck(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("role").equals("ROLE_USER"))
            return request.getRequestURI();
        else
            return "redirect:/login";
    }
 */
}
