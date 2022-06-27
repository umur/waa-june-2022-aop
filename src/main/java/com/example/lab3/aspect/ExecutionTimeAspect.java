package com.example.lab3.aspect;

import com.example.lab3.DTO.ActivityLogDto;
import com.example.lab3.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(com.example.lab3.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

//    @Before("execution(* com.example.lab3.service.*.*(..))")
//    public void checkPostRequestheader()
//    {

//    }
    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object object = proceedingJoinPoint.proceed();
        long end = System.nanoTime();

        ActivityLogDto activityLogDto = new ActivityLogDto();
        activityLogDto.setDate(LocalDate.now());
        activityLogDto.setDuration(start - end);
        activityLogDto.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLogService.create(activityLogDto);

        return object;
    }

}
