package com.example.BookStoreWithMappings.validitaion;

import com.example.BookStoreWithMappings.models.AdminModel;
import com.example.BookStoreWithMappings.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class adminValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminModel admin=(AdminModel) target;
        System.out.println(admin.getAdminId()+" "+admin.getAdminPassword());
        if(admin.getAdminId()!=null && (admin.getAdminId().toString().length()>5)){
            errors.rejectValue("adminId","adminId","must be digits");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminId", "adminId.empty");

        if(admin.getAdminPassword()!=null && admin.getAdminPassword().toString().length()>9){
            errors.rejectValue("adminPassword","password");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminPassword","password.empty");

    }

    public void validateAdminLogin(Object target,Errors errors){
        AdminModel admin= (AdminModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminId", "adminId.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminPassword","password.empty");

    }
}
