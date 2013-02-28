package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.AnswFormDTO;
import com.sam.quest.dto.AnswQuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.service.AnswFormsService;
import com.sam.quest.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AnswFormsController {
    @Autowired
    private AnswFormsService answFormsService;

    @RequestMapping("/**/answForms")
    public String startInit(HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        List<AnswFormDTO> answForms = null;
        try {
            answForms = answFormsService.getAnswForms();
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("answForms", answForms);
        return request.getPathInfo();
    }

    @RequestMapping("/**/answFormsQuestions")
    public String answList(@RequestParam(value="answId", required=true) String answId, HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        List<AnswQuestionDTO> answQuests = null;
        try {
            answQuests = answFormsService.getAnswQuestions(answId);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        modelMap.addAttribute("answQuests", answQuests);
        return request.getPathInfo();
    }

}
