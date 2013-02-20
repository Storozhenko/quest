package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Forms;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminFormsController {

    @RequestMapping("/admin/adminForms")
    public String startInit(HttpSession session, ModelMap modelMap) {
        MultiService <Forms> serv = new ServiceImpl<Forms>();
        List<Forms> forms = null;
        try {
            forms = serv.listRecord(new Forms());
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", e.getMessage());
        }
        modelMap.addAttribute("forms", forms);
        return "/admin/adminForms";
    }

}
