package edu.miu.aop.aspect;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ActivityLogAspect {
    private final ActivityLogService activityLogService;

    public ActivityLogAspect(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @Pointcut("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog al = new ActivityLog(LocalDate.now(), ("method:" + proceedingJoinPoint.getSignature().getName()), finish - start);
        activityLogService.save(al);
        return result;
    }
}