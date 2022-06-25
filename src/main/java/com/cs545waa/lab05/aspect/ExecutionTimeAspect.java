package com.cs545waa.lab05.aspect;

import com.cs545waa.lab05.dto.ActivityLogDTO;
import com.cs545waa.lab05.service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@AllArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogService service;
@Pointcut("@annotation(com.cs545waa.lab05.aspect.annotation.ExecutionTime)")
public void a(){}
    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result  = proceedingJoinPoint.proceed();
        long finish=System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName()+" took "+(finish-start));
        service.create(new ActivityLogDTO(0, LocalDate.now(),proceedingJoinPoint.getSignature().toLongString(),(finish-start)));
        return result;
}
}
