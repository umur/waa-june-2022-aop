package com.example.demo.aspect;

import com.example.demo.model.ActivityLog;
import com.example.demo.service.imple.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.waa_lab5_v1.aspect.annotation.ExecutionTime)")
    public void executionAnnotation() { }

    @Around("executionAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.nanoTime();
        var result = pjp.proceed();
        long finish = System.nanoTime();
        System.out.println(pjp.getSignature().getName() + " takes ns: " + (finish - start));
        System.out.println(request.getMethod());

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDuration(finish - start);
        activityLog.setOperation(request.getMethod());
        activityLogService.createActivityLog(activityLog);
        return result;
    }
}
