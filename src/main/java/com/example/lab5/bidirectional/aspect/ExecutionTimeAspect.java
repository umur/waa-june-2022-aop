package com.example.lab5.bidirectional.aspect;

import com.example.lab5.bidirectional.entity.ActivityLog;
import com.example.lab5.bidirectional.service.ActivityService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {
    private final ActivityService activityService;

    public ExecutionTimeAspect(ActivityService activityService) {
        this.activityService = activityService;
    }


    @Pointcut("@annotation(com.example.lab5.bidirectional.aspect.annotations.ExecutionTime)")
    //get the annotations method
    public void a() {
    }//always empty, just like method declaration and we can use later

    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        //saving into the activity log
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(end-start);
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activityService.save(activityLog);
        return result;
    }

}
