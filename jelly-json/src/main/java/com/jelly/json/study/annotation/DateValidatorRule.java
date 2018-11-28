package com.jelly.json.study.annotation;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidatorRule extends AbstractCustomerValidatorRule {

    @Override
    public boolean support(Annotation annotation) {
        return annotation instanceof DateTimeFormat;
    }

    @Override
    public void validProperty(Annotation annotation, Object property, PostHandler postHandler) {
        DateTimeFormat dtf= (DateTimeFormat) annotation;
        if(parse(dtf.pattern(), (String) property)==null){
            postHandler.postHandler(dtf.errorCode(),dtf.message());
        }
    }
    private  Date parse(String pattern,String property){
        try
        {
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            return sdf.parse(property);
        }catch (ParseException ex)
        {}
        return null;
    }
}
