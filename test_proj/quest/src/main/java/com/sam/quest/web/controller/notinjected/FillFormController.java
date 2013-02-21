package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FillFormController {

    @RequestMapping("/**/fillForm")
    public String startInit(@RequestParam(value="formId", required=true) String formId, HttpSession session, ModelMap modelMap) {
        MultiService <Forms> serv = new ServiceImpl<Forms>();
        Forms form;
        try {
            form = serv.findRecord(Long.valueOf(formId), new Forms());
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        List<Questions> questList = new ArrayList<Questions>();
        return "fillForm";
    }

}
