package com.jelly.json.study.annotation;

import org.junit.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.Errors;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractCustomerValidatorRule implements CustomerValidatorRule {
    @Override
    public abstract boolean support(Annotation annotation);

    @Override
    public void valid(Annotation annotation, Object object, Field field, Errors errors) throws InvocationTargetException, IllegalAccessException {
        preHandle(annotation,object,field,errors);
        PropertyDescriptor propertyDescriptor= BeanUtils.getPropertyDescriptor(object.getClass(),field.getName());
        Method reader=propertyDescriptor.getReadMethod();
        Object property=reader.invoke(object);
        validProperty(annotation, property, new PostHandler() {
            @Override
            public void postHandler(String errorCode, String message) {
                errors.rejectValue(field.getName(),errorCode,message);
            }
        });

    }
    public  static  interface  PostHandler{
        public  void postHandler(String errorCode,String message);
    }
    private void preHandle(Annotation annotation,Object target,Field field,Errors errors){
        Assert.assertNotNull(target);
        Assert.assertNotNull(annotation);
        Assert.assertNotNull(errors);
        Assert.assertNotNull(field);
    }
    public abstract  void validProperty(Annotation annotation,Object property,PostHandler postHandler);
}
