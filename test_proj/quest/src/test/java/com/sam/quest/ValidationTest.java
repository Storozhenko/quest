package com.sam.quest;

import com.sam.quest.dto.FormDTO;
import com.sam.quest.web.validator.GeneralValidator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class ValidationTest extends Assert {

    @Test
    public void testGeneralValidator() {
        GeneralValidator<FormDTO> generalValidator = new GeneralValidator<FormDTO>();
        FormDTO formDTO = new FormDTO();
        formDTO.setFormName("fdd");
        Errors errors = new BeanPropertyBindingResult(formDTO, "formDTO");
        generalValidator.validate(formDTO, errors);
        assertNull(errors.getFieldError("formName"));
    }
}