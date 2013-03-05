package com.sam.quest.web.controller.autowired;

import com.sam.quest.entity.Forms;
import com.sam.quest.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/**/formsTable")
    public @ResponseBody Map<String, Object[]> getForms() {
        List<Forms> forms = null;
        try {
            forms = formsService.getForms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[forms.size()];
        int i = 0;
        for (Forms f : forms) {
            Object[] us = new String[]{f.getFormName(), f.getFormDescr(), String.valueOf(f.getFormId())};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("iTotalRecords", String.valueOf(10));
        map.put("iTotalDisplayRecords", String.valueOf(10));
        map.put("aaData", rdArray);
        return map;
    }

}
