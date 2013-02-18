package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        modelMap.addAttribute("users", u);
        return "admin/users";
    }

}
