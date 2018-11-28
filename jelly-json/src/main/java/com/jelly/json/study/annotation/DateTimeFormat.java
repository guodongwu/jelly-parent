package com.jelly.json.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@CustomerValidator
public @interface DateTimeFormat {
    String pattern() default "yyyy-MM-dd HH:mm:ss";
    String errorCode() default "must date";
    String message()default "must be date pattern";

}
