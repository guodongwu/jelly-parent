package com.jelly.jellyspringboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class ControllerAop  {
    @Pointcut("execution(public * com.jelly.jellyspringboot.controller.*.*(..))")
    public void log(){}
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
        Object[] objects=joinPoint.getArgs();
        Signature signature=joinPoint.getSignature();

        System.out.println("方法："+signature.getName());
        System.out.println("方法所在包:"+signature.getDeclaringTypeName());
        System.out.println("class:"+signature.getDeclaringType());
        MethodSignature methodSignature= (MethodSignature) signature;
        String [] strs=methodSignature.getParameterNames();
        System.out.println("参数名："+Arrays.toString(strs));
        System.out.println("参数名ARGs："+ Arrays.toString(joinPoint.getArgs()));
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req=attributes.getRequest();
        System.out.println("请求URL:"+req.getRequestURL().toString());
        System.out.println("HTTP_METHOD:"+req.getMethod());
        System.out.println("IP"+req.getRemoteAddr());
        System.out.println("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());










    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterReturning(Object ret){
        System.out.println("方法返回值："+ret);
    }
    @AfterThrowing("log()")
    public  void doAfterThrowing(){
        System.out.println("方法异常...");
    }
    @After("log()")
    public void after(){}
    @Around("log()")
    public  Object arround(ProceedingJoinPoint joinPoint){
        try {
            Object o=joinPoint.proceed();
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return  null;
        }

    }

}
