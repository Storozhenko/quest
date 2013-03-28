package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.FormDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;
import com.sam.quest.service.FormsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FormsListController {
    @Autowired
    private FormsListService formsListService;

    @RequestMapping("/**/forms")
    public String startInit(HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return request.getPathInfo();
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/admin/formsTable")
         public @ResponseBody Map<String, Object[]> getAdminForms() {
        List<Forms> forms = null;
        try {
            forms = formsListService.getForms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[forms.size()];
        int i = 0;
        for (Forms f : forms) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(f.getFormDate());
            Object[] us = new String[]{f.getFormId().toString(), f.getFormName(),
                    f.getFormDescr(), f.getUserId().getUsername(), date};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("iTotalRecords", forms.size());
        map.put("iTotalDisplayRecords", forms.size());
        map.put("aaData", rdArray);
        return map;
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/user/formsTable")
    public @ResponseBody Map<String, Object[]> getUserForms() {
        List<Forms> forms = null;
        try {
            forms = formsListService.getForms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[forms.size()];
        int i = 0;
        boolean access;
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (Forms f : forms) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(f.getFormDate());
            access = false;
            if (f.getUserId().getUsername().equals(user.getUsername())) {
                access = true;
            }
            Object[] us = new String[]{f.getFormId().toString(), f.getFormName(),
                    f.getFormDescr(), f.getUserId().getUsername(), date, String.valueOf(access)};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("iTotalRecords", forms.size());
        map.put("iTotalDisplayRecords", forms.size());
        map.put("aaData", rdArray);
        return map;
    }
}
