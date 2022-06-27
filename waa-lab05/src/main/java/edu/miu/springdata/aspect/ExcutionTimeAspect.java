package edu.miu.springdata.aspect;

import edu.miu.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
@RestController
public class ExcutionTimeAspect {
    private final ActivityLogService activityLogService;



    @Pointcut("@annotation(edu.miu.springdata.service.ExecutionTime)")
    public void excutionTimeAnnotation(){

    }
@Around("excutionTimeAnnotation()")
    public Object calculateExcutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish  = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName()+"take ns:"+(finish-start));
    activityLogService.create(new Date(),proceedingJoinPoint.getSignature().getName(),(finish-start));

    return result;
    }
}
