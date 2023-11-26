/*
package com.sbs.utils.Annotations;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Aspect
@Component
public class FloatFormatAspect {
    @Around("@annotation(FloatFormat)")
    public Object setFloatFormat(ProceedingJoinPoint joinPoint) throws Throwable {
        Object requestObject = joinPoint.getArgs();
        DecimalFormat df = new DecimalFormat("#.##");
        Float.parseFloat(df.format(requestObject));
        return joinPoint.proceed();
    }
}
*/