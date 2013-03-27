package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.AnswFormDTO;
import com.sam.quest.dto.AnswQuestionDTO;
import com.sam.quest.service.AnswFormService;
import com.sam.quest.service.AnswFormsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnswFormController {
    @Autowired
    private AnswFormService answFormService;

    @RequestMapping("/admin/deleteAnswForm")
    public String startInit(@RequestParam(value="answId", required=true) String answId, HttpSession session) {
        try {
            answFormService.deleteAnswForm(Long.valueOf(answId));
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        return "/admin/answForms";
    }
}
