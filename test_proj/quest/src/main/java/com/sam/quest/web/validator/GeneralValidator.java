package com.sam.quest.web.validator;

import com.sam.quest.dto.annotations.Required;
import com.sam.quest.dto.annotations.TextLength;
import com.sam.quest.dto.annotations.Validatable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;


@Component
public class GeneralValidator <E> implements Validator{

    public final boolean supports(final Class clazz) {
        return clazz.isAnnotationPresent(Validatable.class);
    }

    public void validate(Object target, Errors errors) {
        E obj = (E) target;
        final PropertyDescriptor[] propertyDescriptors
                = BeanUtils.getPropertyDescriptors(obj.getClass());
        for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            // see if the getter is annotated as required
            final Method method = propertyDescriptor.getReadMethod();
            if (method != null && method.isAnnotationPresent(Required.class)) {
                String field = propertyDescriptor.getName();
                ValidationUtils.rejectIfEmpty(errors, field, "label.validator." + field + ".required");
                if (method.isAnnotationPresent(TextLength.class)) {
                    TextLength annotation = method.getAnnotation(TextLength.class);
                    String value = null;
                    try {
                        value = (String) propertyDescriptor.getReadMethod().invoke(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (value.length() < annotation.minLength()) {
                        errors.rejectValue(field, "label.validator." + field + ".tooShort");
                    } else {
                        if (value.length() > annotation.maxLength()) {
                            errors.rejectValue(field, "label.validator." + field + ".tooLong");
                        }
                    }
                }
            }
        }
    }
}