package com.sam.quest.web.controller.autowired;

import com.sam.quest.dto.AnswFormDTO;
import com.sam.quest.dto.AnswQuestionDTO;
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
public class AnswFormsListController {
    @Autowired
    private AnswFormsListService answFormsListService;

    @RequestMapping("/**/answForms")
    public String startInit(HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        return request.getPathInfo();
    }

    @RequestMapping("/**/answFormsQuestions")
    public String answList(@RequestParam(value="answId", required=true) String answId, HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        session.setAttribute("answId", answId);
        return request.getPathInfo();
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/**/answFormsTable")
    public @ResponseBody Map<String, Object[]> getAnswForms() {
        List<AnswFormDTO> answForms = null;
        try {
            answForms = answFormsListService.getAnswForms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[answForms.size()];
        int i = 0;
        for (AnswFormDTO f : answForms) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(f.getAnswDatetime());
            Object[] us = new String[]{f.getFormName(), f.getUsername(), date, String.valueOf(f.getAnswId())};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("aaData", rdArray);
        return map;
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/**/answQuestsTable")
    public @ResponseBody Map<String, Object[]> getAnswQuestions(@RequestParam(value="answId", required=true) String answId) {
        List<AnswQuestionDTO> answQuests = null;
        try {
            answQuests = answFormsListService.getAnswQuestions(Long.valueOf(answId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[answQuests.size()];
        int i = 0;
        for (AnswQuestionDTO f : answQuests) {
            StringBuffer sb = new StringBuffer();
            int j = 0;
            for (String option: f.getUserAnswer()) {
                if (j > 0)
                    sb.append(", ");
                sb.append(option);
                j++;
            }
            Object[] us = new String[]{f.getQuestionName(), f.getQuestionDescr(), sb.toString()};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("aaData", rdArray);
        return map;
    }

}
