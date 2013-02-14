package com.sam.quest.web.controller;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestListController {

    @RequestMapping("/tests")
    public String startInit(HttpSession session) {
        MultiService <Users> serv = new ServiceImpl<Users>();
        //List<Users> users = serv.listRecord(new Users());
        //session.setAttribute("users", users);
        return "tests";
    }

}
