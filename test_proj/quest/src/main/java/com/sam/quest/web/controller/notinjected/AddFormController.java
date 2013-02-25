package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ImplService;
import com.sam.quest.web.dto.FormDTO;
import com.sam.quest.web.dto.QuestionDTO;
import com.sam.quest.web.validator.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class AddFormController {
    @Autowired
    private FormValidator formValidator;

    @RequestMapping("/**/addForm")
    public String startInit(HttpSession session, ModelMap modelMap) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return "addForm";
    }

    @RequestMapping("/**/addFormAction")
    public String addForm(HttpSession session, ModelMap modelMap, @ModelAttribute("form")FormDTO form, BindingResult result) {
        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "addForm";
        }
        Forms newForm = new Forms();
        Users user = new Users();
        Long userId = (Long)session.getAttribute("userId");
        MultiService <Users> servUsers = new ImplService<Users>();
        try {
            user = servUsers.findRecord(userId, user);
        } catch (Exception e) {
            e.printStackTrace();
            return "addForm";
        }
        newForm.setFormName(form.getFormName());
        newForm.setUserId(user);
        newForm.setFormDate(new Date(System.currentTimeMillis()));
        MultiService <Forms> servForms = new ImplService<Forms>();
        try {
            servForms.insertRecord(newForm);
            List<Forms> list = servForms.listRecord(new Forms());
            for (Forms f : list) {
                if (f.getFormName().equals(form.getFormName())) {
                    session.setAttribute("formId", f.getFormId());
                    session.setAttribute("questionNum", 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "addForm";
        }
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        return "redirect:/addQuestion";
    }
}
