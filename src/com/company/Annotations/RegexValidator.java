package com.company.Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
@Repeatable(RegexValidators.class)
public @interface RegexValidator {
    public String pattern();
    public String message();
}
