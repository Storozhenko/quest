package com.sam.quest.web.controller;

import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.dto.UserDTO;
import com.sam.quest.entity.Users;
import com.sam.quest.service.FormsListService;
import com.sam.quest.service.UsersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UsersListController {
    @Autowired
    private UsersListService usersListService;
    private List<String> typeList;
    private List<String> typeListText = new ArrayList<String>();
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/admin/users")
    public String usersList(Locale locale, HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        UserDTO user = new UserDTO();
        modelMap.addAttribute("user", user);
        return request.getPathInfo();
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/admin/usersTable")
    public @ResponseBody Map<String, Object[]> getAdminUsers(Locale locale) {
        List<Users> users = null;
        try {
            users = usersListService.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[users.size()];
        int i = 0;
        for (Users u : users) {
            String lang = "";
            if (!u.getUserLang().equals(""))
                lang = messageSource.getMessage("label.language." + u.getUserLang(), null, locale);
            Object[] us = new String[]{String.valueOf(u.getUserId()), u.getUsername(),
                    u.getPassword(), messageSource.getMessage("label." + u.getUserType(), null, locale), lang};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("aaData", rdArray);
        return map;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
