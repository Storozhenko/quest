package com.sam.quest.web.controller;

import com.sam.quest.dto.FormDTO;
import com.sam.quest.dto.QuestionDTO;
import com.sam.quest.entity.Forms;
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
public class QuestionsListController {
    @Autowired
    private FormsListService formsListService;
    private List<String> typeList;
    private List<String> typeListText = new ArrayList<String>();
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/**/formQuestions")
    public String answList(@RequestParam(value="formId", required=true) String formId, Locale locale, HttpSession session, ModelMap modelMap, HttpServletRequest request) {
        QuestionDTO question = new QuestionDTO();
        modelMap.addAttribute("question", question);
        typeListText.clear();
        for (String type : typeList) {
            typeListText.add(messageSource.getMessage(type, null, locale));
        }
        modelMap.addAttribute("types", typeListText);
        session.setAttribute("formId", formId);
        return request.getPathInfo();
    }

    @RequestMapping(method={RequestMethod.POST,RequestMethod.GET}, value="/admin/formQuestsTable")
    public @ResponseBody Map<String, Object[]> getAdminFormsQuests(@RequestParam(value="formId", required=true) String formId) {
        List<QuestionDTO> quests = null;
        try {
            quests = formsListService.getFormsQuestions(Long.valueOf(formId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] rdArray = new Object[quests.size()];
        int i = 0;
        int j;
        for (QuestionDTO q : quests) {
            int type = Integer.valueOf(q.getQuestionType());
            StringBuffer sb = new StringBuffer();
            j = 0;
            for (String option : q.getQuestionOptions()) {
                if (j > 0)
                    sb.append(", ");
                sb.append(option);
                j++;
            }
            Object[] us = new String[]{String.valueOf(q.getQuestionId()), q.getQuestionName(),
                    q.getQuestionDescr(), typeListText.get(type-1), String.valueOf(j), sb.toString()};
            rdArray[i] = us;
            i++;
        }
        Map map = new HashMap<String, Object[]>();
        map.put("aaData", rdArray);
        return map;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
