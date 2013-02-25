package com.sam.quest.web.controller.notinjected;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminMainController {

    @RequestMapping("/admin/adminMain")
    public String startInit(HttpSession session, ModelMap modelMap) {
        return "/admin/adminMain";
    }

}
