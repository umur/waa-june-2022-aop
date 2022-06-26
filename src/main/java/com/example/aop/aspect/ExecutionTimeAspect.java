package com.example.aop.aspect;

import com.example.aop.entity.ActivityLog;
import com.example.aop.repo.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(com.example.aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();

        String methodName = "Method Name:" + proceedingJoinPoint.getSignature().getName();
        long duration = finish-start;
        ActivityLog activityLog = new ActivityLog(LocalDate.now(), methodName, duration);
        activityLogRepo.save(activityLog);
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: "+ (finish-start));
        return result;
    }

}
