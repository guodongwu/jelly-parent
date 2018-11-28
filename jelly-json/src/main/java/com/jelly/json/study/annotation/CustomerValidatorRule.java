package com.jelly.json.study.annotation;

import org.springframework.validation.Errors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public interface CustomerValidatorRule {
    public  boolean support(Annotation annotation);
    public  void valid(Annotation annotation, Object object, Field field, Errors errors) throws InvocationTargetException, IllegalAccessException;

}
