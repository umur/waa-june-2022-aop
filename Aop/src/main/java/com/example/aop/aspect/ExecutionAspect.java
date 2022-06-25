package com.example.aop.aspect;

import com.example.aop.entity.ActivityLog;
import com.example.aop.repository.IActivityLogRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExecutionAspect {

    @Autowired
    private IActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(com.example.aop.aspect.annotation.ExecutionTime)")
    private void executionAnnotation() {
    }

    @Before("executionAnnotation()")
    public void exeBefore(JoinPoint joinPoint) {
        System.out.println("Before");
    }

    @After("executionAnnotation()")
    public void exeAfter() {
        System.out.println("After");
    }

    @Around("executionAnnotation()")
    public Object calc(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + "Takes" + finish);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDuration(String.valueOf((finish - start)));
        activityLog.setDate(new Date());
        activityLogRepo.save(activityLog);
        return result;
    }
}