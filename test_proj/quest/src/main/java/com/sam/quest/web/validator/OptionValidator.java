package com.sam.quest.web.validator;

import com.sam.quest.web.dto.OptionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class OptionValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return OptionDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        OptionDTO option = (OptionDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "optionNum", null);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "optionData", "label.validator.optionNameEmpty");
        String optData = option.getOptionData();
        if ((optData.length()) > 45) {
            errors.rejectValue("optionData", "label.validator.optionNameTooLong");
        }
    }
}