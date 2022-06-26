package edu.miu.Lab05.aspect;

import edu.miu.Lab05.dto.LabAopDto;
import edu.miu.Lab05.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.Lab05.aspect.annotation.ExecutionTime)")
    public void ExecutionTimeCalc(){}

    @Around("ExecutionTimeCalc()")

    public  Object CalcExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName()+"takes ns:"+ (end-start));
        LabAopDto labAopDto = new LabAopDto(LocalDate.now(), (proceedingJoinPoint.getSignature().getName()), end - start);
        activityLogService.save(labAopDto);
        return  result;
    }
}
