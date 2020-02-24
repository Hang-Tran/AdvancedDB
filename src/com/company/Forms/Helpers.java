package com.company.Forms;

import com.company.Validator;

import java.lang.reflect.Field;

public class Helpers {
    public static boolean validateAndPrint(Field field, String value) {
        var validations = Validator.validate(field, value);

        if (validations != null) {
            System.out.println(String.join("\n", validations));
            return false;
        }
        return true;
    }
}
