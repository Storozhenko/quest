package com.sam.quest.web;


import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private static Map<String, Users> usersMap = new HashMap<String, Users>();

    @RequestMapping("/login")
    public String startRedirect(Map<String, Object> session) {
        //message = "Hello World, Spring 3.0!";
        session.put("message", message);
        return "main";
    }
       /*
    @RequestMapping("/login")
    public String checkUser(Map<String, Object> session, @ModelAttribute("username") String username,
    @ModelAttribute("password") String password) {
        MultiService <Users> serv = new ServiceImpl<Users>();
        List<Users> users = serv.listRecord(new Users());
        usersMap.clear();
        for (Users u: users) {
            String userKey = u.getUsername();
            usersMap.put(userKey, u);
        }
        String userKey = username;
        Users user = (Users)usersMap.get(username);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                session.put("user", user);
                return "main";
            } else {
                //addFieldError("password", "Invalid password");
                return "login";
            }
        } else {
            //addFieldError("username", "Invalid username");
            return "login";
        }

    }     */
}
