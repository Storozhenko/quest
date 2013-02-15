package com.sam.quest.web.controller;

import com.sam.quest.entity.Forms;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminUsersController {

    @RequestMapping("/admin/users")
    public String startInit(HttpSession session, ModelMap modelMap) {
        MultiService <Users> serv = new ServiceImpl<Users>();
        List<Users> u = null;
        try {
            u = serv.listRecord(new Users());
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("users", u);
        return "admin/users";
    }

}
