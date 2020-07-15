package com.jelly.json.study.annotation;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class CustomerValidatorFactory implements Validator {
    @Autowired
    private CustomerValidatorConfig customerValidatorConfig;
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Assert.assertNotNull(target);
        Assert.assertNotNull(errors);
        List<Field> fields=getFields(target.getClass());
        for (Field field:fields){
            Annotation[] annotations=field.getAnnotations();
            for (Annotation annotation:annotations){
                if(annotation.annotationType().getAnnotation(CustomerValidator.class)!=null){
                    CustomerValidatorRule customerValidatorRule=customerValidatorConfig.findRule(annotation);
                    if(customerValidatorRule!=null){
                        try {
                            customerValidatorRule.valid(annotation,target,field,errors);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    private List<Field> getFields(Class<?> aClass) {
        List<Field> fields=new ArrayList<Field>();
        while (aClass!=null){
            Collections.addAll(fields,aClass.getDeclaredFields());
            aClass=aClass.getSuperclass();
        }
        return  fields;
    }
}
