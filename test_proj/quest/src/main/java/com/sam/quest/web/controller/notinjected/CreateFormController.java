package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import com.sam.quest.web.dto.FormDTO;
import com.sam.quest.web.dto.QuestionDTO;
import com.sam.quest.web.validator.FormValidator;
import com.sam.quest.web.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CreateFormController {
    @Autowired
    private FormValidator formValidator;

    @RequestMapping("/**/createForm")
    public String startInit(HttpSession session, ModelMap modelMap) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return "createForm";
    }

    @RequestMapping("/**/createFormAction")
    public String addForm(HttpSession session, ModelMap modelMap, @ModelAttribute("form")FormDTO form, BindingResult result) {
        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "createForm";
        }
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
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        return "redirect:/addQuestion";
    }
}
