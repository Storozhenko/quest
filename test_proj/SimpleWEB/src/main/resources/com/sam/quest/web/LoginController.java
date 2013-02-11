package com.sam.quest.web;


import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public List<Users> listRecord() {
        MultiService <Users> serv = new ServiceImpl<Users>();
        return serv.listRecord(new Users());
    }
}
