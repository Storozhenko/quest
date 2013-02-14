package com.sam.quest.web.controller;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.LoginForm;
import com.sam.quest.web.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminUsersController {

    @RequestMapping("/admin/users")
    public String startRedirect(HttpSession session) {
        MultiService <Users> serv = new ServiceImpl<Users>();
        //List<Users> users = serv.listRecord(new Users());
        //session.setAttribute("users", users);
        return "admin/users";
    }

}
