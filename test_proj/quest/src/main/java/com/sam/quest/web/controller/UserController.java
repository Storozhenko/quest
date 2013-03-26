package com.sam.quest.web.controller;

import com.sam.quest.dto.OptionDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.dto.UserDTO;
import com.sam.quest.entity.Questions;
import com.sam.quest.service.QuestionService;
import com.sam.quest.service.UserService;
import com.sam.quest.web.validator.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private GeneralValidator userValidator;
    @Autowired
    private UserService userService;
    private List<String> typeList;

    @RequestMapping("/admin/addUser")
    public String startInit(HttpSession session, ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        return "/admin/addUser";
    }

    @RequestMapping("/admin/addUserAction")
    public String addQuestion(HttpSession session, ModelMap modelMap, @ModelAttribute("user")UserDTO user,
                              BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "addUser";
        }
        try {
            userService.addUser(user);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/admin/users";
    }

    @RequestMapping("/{role}/deleteUserAction")
    public String deleteQuestion(@RequestParam(value="userId", required=true) String userId, HttpSession session,
                                 @PathVariable("role") String role) {
        try {
            userService.deleteUser(Long.valueOf(userId));
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/" + role + "/users";
    }

    @RequestMapping("/{role}/updateUserAction")
    public String updateQuestion(HttpSession session, @PathVariable("role") String role, @ModelAttribute("user")UserDTO user) {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "redirect:/" + role + "/users";
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
