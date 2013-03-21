package com.sam.quest.web.controller;

import com.sam.quest.dto.FormDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Questions;
import com.sam.quest.service.FormsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
    private List<String> typeList;
    private List<String> typeListText = new ArrayList<String>();
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/**/forms")
    public String startInit(HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        FormDTO form = new FormDTO();
        modelMap.addAttribute("form", form);
        return request.getPathInfo();
    }
    @RequestMapping("/**/formsQuestions")
    public String answList(@RequestParam(value="formId", required=true) String formId, Locale locale, HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        typeListText.clear();
        for (String t : typeList) {
            typeListText.add(messageSource.getMessage(t, null, locale));
        }
        modelMap.addAttribute("types", typeListText);
        session.setAttribute("formId", formId);
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

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/admin/formsQuestsTable")
    public @ResponseBody Map<String, Object[]> getAdminFormsQuests(@RequestParam(value="formId", required=true) String formId) {
        List<Questions> quests = null;
        try {
            quests = formsListService.getFormsQuestions(Long.valueOf(formId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[quests.size()];
        int i = 0;
        for (Questions q : quests) {
            int type = q.getQuestionType();
            Object[] us = new String[]{q.getQuestionId().toString(), q.getQuestionName(),
                    q.getQuestionDescr(),  typeListText.get(type-1) };
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("iTotalRecords", quests.size());
        map.put("iTotalDisplayRecords", quests.size());
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
        for (Forms f : forms) {
            Object[] us = new String[]{f.getFormName(), f.getFormDescr(), String.valueOf(f.getFormId())};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("iTotalRecords", forms.size());
        map.put("iTotalDisplayRecords", forms.size());
        map.put("aaData", rdArray);
        return map;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
