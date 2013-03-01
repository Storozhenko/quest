package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminUsersController {

    @RequestMapping("/admin/users")
    public String startInit(HttpSession session, ModelMap modelMap) {
        List<Users> u = null;
        modelMap.addAttribute("users", u);
        return "admin/users";
    }

}
