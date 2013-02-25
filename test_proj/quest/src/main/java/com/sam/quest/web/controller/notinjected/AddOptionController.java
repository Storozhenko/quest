package com.sam.quest.web.controller.notinjected;

import com.sam.quest.entity.Questions;
import com.sam.quest.entity.QuestionsData;
import com.sam.quest.service.MultiService;
import com.sam.quest.service.ImplService;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.web.validator.OptionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddOptionController {
    @Autowired
    private OptionValidator optionValidator;


    @RequestMapping("/**/addOption")
    public String startInit(HttpSession session, ModelMap modelMap) {
        OptionDTO option = new OptionDTO();
        option.setOptionNum(1);
        modelMap.addAttribute("option", option);
        return "addOption";
    }

    @RequestMapping("/**/addOptionAction")
    public String addOption(HttpSession session, ModelMap modelMap, @ModelAttribute("option")OptionDTO option, BindingResult result) {
        optionValidator.validate(option, result);
        if (result.hasErrors()) {
            return "addOption";
        }
        QuestionsData qd = new QuestionsData();
        Questions q = new Questions();
        q.setQuestionId((Long)session.getAttribute("questionId"));
        qd.setQuestionId(q);
        qd.setQuestionOption(option.getOptionNum());
        qd.setOptionData(option.getOptionData());
        MultiService<QuestionsData> serv = new ImplService<QuestionsData>();
        try {
            serv.insertRecord(qd);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        OptionDTO newOption = new OptionDTO();
        newOption.setOptionNum(option.getOptionNum() + 1);
        modelMap.addAttribute("option", newOption);
        int type = (Integer)session.getAttribute("type");
        if (type == 1) {
            return "redirect:/addQuestion";
        } else {
            return "addOption";
        }
    }

}
