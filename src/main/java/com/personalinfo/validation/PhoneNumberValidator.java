package com.personalinfo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValidate, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null values should be handled separately using @NotNull
        return value != null && (value.length() == 10);
    }
}
