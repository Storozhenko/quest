package com.sam.quest.web.controller;

import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.form.FormForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CreateFormController {

    @RequestMapping("admin/createForm")
    public String startInit(HttpSession session, ModelMap modelMap) {
        FormForm form = new FormForm();
        modelMap.addAttribute("form", form);
        return "createForm";
    }

    @RequestMapping("admin/createFormAction")
    public String addQuest(HttpSession session, @ModelAttribute("form")FormForm form, BindingResult result) {
        Forms newForm = new Forms();
        Users user = new Users();
        Long userId = (Long)session.getAttribute("userId");
        MultiService <Users> servUsers = new ServiceImpl<Users>();
        try {
            user = servUsers.findRecord(userId, user);
        } catch (Exception e) {
            e.printStackTrace();
            return "createForm";
        }
        newForm.setFormName(form.getFormName());
        newForm.setUserId(user);
        newForm.setFormDate(new Date(System.currentTimeMillis()));
        MultiService <Forms> servForms = new ServiceImpl<Forms>();
        try {
            servForms.addRecord(newForm);
        } catch (Exception e) {
            e.printStackTrace();
            return "createForm";
        }
        return "admin/adminForms";
    }

}
