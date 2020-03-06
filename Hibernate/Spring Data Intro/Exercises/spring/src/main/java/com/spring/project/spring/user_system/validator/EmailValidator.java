package com.spring.project.spring.user_system.validator;

import com.spring.project.spring.user_system.constants.AppConstants;
import com.spring.project.spring.user_system.validator.annotations.Email;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailValidator implements ConstraintValidator<Email, CharSequence> {

    private int minLength;
    private int minHostLen;
    private int maxHostLen;
    private boolean containsDigit;
    private boolean containsLowercase;
    private boolean containsUppercase;

    @Override
    public void initialize(Email constraintAnnotation) {
        minLength = constraintAnnotation.minNameLength();
        minHostLen = constraintAnnotation.minNameLength();
        maxHostLen = constraintAnnotation.maxHostLength();

        containsDigit = constraintAnnotation.containsDigit();
        containsLowercase = constraintAnnotation.containsLowercase();
        containsUppercase = constraintAnnotation.containsUppercase();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        String emailValue = value.toString();

        int userNameLen = emailValue.indexOf("@");

        int hostLen = emailValue.length() - emailValue.lastIndexOf("@") - 1;

        if (userNameLen < minLength) {
            context.buildConstraintViolationWithTemplate(AppConstants.EMAIL_TOO_SHORT)
                    .addConstraintViolation();
            return false;
        }

        if (hostLen < minHostLen) {
            context.buildConstraintViolationWithTemplate(AppConstants.HOST_TOO_SHORT)
                    .addConstraintViolation();
            return false;
        }

        if (hostLen > maxHostLen) {
            context.buildConstraintViolationWithTemplate(AppConstants.HOST_TOO_LONG)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
