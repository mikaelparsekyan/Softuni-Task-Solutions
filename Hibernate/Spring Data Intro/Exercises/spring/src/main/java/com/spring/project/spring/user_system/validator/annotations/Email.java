package com.spring.project.spring.user_system.validator.annotations;

import com.spring.project.spring.user_system.constants.AppConstants;
import com.spring.project.spring.user_system.validator.EmailValidator;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    int minNameLength() default 4;

    int minHostLength() default 50;

    int maxHostLength() default 50;

    boolean containsDigit() default false;

    boolean containsLowercase() default false;

    boolean containsUppercase() default false;

    String message() default AppConstants.INVALID_EMAIL;

    String regex() default "^([a-zA-Z0-9][-_.]?)*[a-zA-Z0-9]@([a-zA-Z][-]?)*[a-zA-Z](\\.([a-zA-Z][-]?)*[a-zA-Z])+$";
}
