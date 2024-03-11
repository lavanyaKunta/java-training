package com.example.Appointment.Management.System.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AppointmentTypeValidator.class})

public @interface validAppointmentType {
    String message() default  "Invalid appointment type";
    Class<?>[] groups()default{};
    Class<? extends Payload>[] payload() default{};
}
