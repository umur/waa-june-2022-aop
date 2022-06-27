package com.example.demo.aspect;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repo.ActivityLogRepo;
import com.example.demo.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {


    private final ActivityLogService activityLogService;

    @Pointcut("@annotation( com.example.demo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        activityLogService.save(new ActivityLog(LocalDate.now(),
                proceedingJoinPoint.getSignature().getName(),
                finish));
        return result;
    }

}
