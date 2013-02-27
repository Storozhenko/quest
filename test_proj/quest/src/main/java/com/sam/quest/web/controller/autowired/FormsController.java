package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Forms;
import com.sam.quest.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FormsController {
    @Autowired
    private FormsService formsService;

    @RequestMapping("/**/forms")
    public String startInit(HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        List<Forms> forms = null;
        try {
            forms = formsService.getForms();
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("forms", forms);
        return request.getPathInfo();
    }

}
