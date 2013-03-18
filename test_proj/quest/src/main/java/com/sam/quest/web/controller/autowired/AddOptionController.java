package com.sam.quest.web.controller.autowired;

import com.sam.quest.service.AddOptionService;
import com.sam.quest.dto.OptionDTO;
import com.sam.quest.web.validator.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddOptionController {
    @Autowired
    private GeneralValidator optionValidator;
    @Autowired
    private AddOptionService addOptionService;

    @RequestMapping("/**/addOption")
    public String startInit(HttpSession session, ModelMap modelMap) {
        OptionDTO option = new OptionDTO();
        option.setOptionNum(1);
        modelMap.addAttribute("option", option);
        return "addOption";
    }

    @RequestMapping("/{role}/addOptionAction")
    public String addOption(HttpSession session, ModelMap modelMap, @PathVariable("role") String role,
                            @ModelAttribute("option")OptionDTO option, BindingResult result) {
        optionValidator.validate(option, result);
        if (result.hasErrors()) {
            return "addOption";
        }
        try {
            addOptionService.addOption(option, session);
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            return "error";
        }
        OptionDTO newOption = new OptionDTO();
        newOption.setOptionNum(option.getOptionNum() + 1);
        modelMap.addAttribute("option", newOption);
        int type = (Integer)session.getAttribute("type");
        if (type == 1) {
            return "redirect:/" + role + "/addQuestion";
        } else {
            return "addOption";
        }
    }

}
