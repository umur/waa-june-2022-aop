package com.example.lab3.Aspect;

import com.example.lab3.Domain.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ActivityAspect {

    @Pointcut("@annotation(com.example.lab3.Annotation.ExecutionTime)")
    public void a(){}
    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        long start=System.nanoTime();
        var output=proceedingJoinPoint.proceed();
        Long finish=System.nanoTime();
        Long timeTaken=finish-start;
        ActivityLog activityLog=new ActivityLog("calculated", LocalDate.now(),timeTaken);
        System.out.println(timeTaken);
        return output;

    }

}
