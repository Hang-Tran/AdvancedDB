package com.company;

import com.company.Annotations.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> validate(Field field, String value) {
        field.setAccessible(true);
        var result = new ArrayList<String>();

        var validators = field.getAnnotationsByType(RegexValidator.class);
        for(var validator: validators){
            if(!value.matches(validator.pattern())) {
                result.add(validator.message());
            }
        }

        return result.size() > 0 ? result : null;
    }
}
