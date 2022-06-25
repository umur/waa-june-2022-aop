package com.example.aop.aspect;

import com.example.aop.repository.IActivityLogRepo;
import com.example.aop.service.IActivityLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}