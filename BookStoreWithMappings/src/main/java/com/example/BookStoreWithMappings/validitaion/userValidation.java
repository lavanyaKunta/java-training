package com.example.BookStoreWithMappings.validitaion;

import com.example.BookStoreWithMappings.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class userValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserModel user=(UserModel) target;
        if(user.getUserId()!=null && (user.getUserId().toString().length()>5)){
            errors.rejectValue("userId","userId");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty");

        if(user.getPassword()!=null && user.getPassword().toString().length()>9){
            errors.rejectValue("password","password");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.empty");

        if(user.getFirstName()!=null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName");
        }
        if(user.getPhoneNo()!=null) {
            System.out.println("lav");
            if (user.getPhoneNo().toString().length() != 10) {
                errors.rejectValue("phoneNo", "phoneNo","phone number must contain 10 digits");
            }
        }
        if(user.getPhoneNo()==null){
            ValidationUtils.rejectIfEmpty(errors,"phoneNo", "phoneNo.empty");
        }
        if(user.getEmail()!=null && !user.getEmail().endsWith("@gmail.com")){
           errors.rejectValue("email","Email");
        }
        if(user.getEmail()==null){
            ValidationUtils.rejectIfEmpty(errors,"email", "email.empty");
        }

    }

    public void validateLogin(Object target,Errors errors){
        UserModel user= (UserModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.empty");

    }


}