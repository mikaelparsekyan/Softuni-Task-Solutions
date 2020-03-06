package com.spring.project.spring.user_system.validator.annotations;

import com.spring.project.spring.user_system.constants.AppConstants;
import com.spring.project.spring.user_system.validator.PasswordValidator;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    int minLength() default 6;

    int maxLength() default 30;

    boolean containsDigit() default true;

    boolean containsLowerCase() default true;

    boolean containsUpperCase() default true;

    boolean containsSpecialSymbols() default true;

    String message() default AppConstants.INVALID_PASSWORD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
