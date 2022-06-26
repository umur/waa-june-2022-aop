package springaop.lab4.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {


    @Pointcut("@annotation(springaop.lab4.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){

    }
@Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
long start=System.nanoTime();
var result= proceedingJoinPoint.proceed();
long end = System.nanoTime();

        System.out.println(proceedingJoinPoint.getSignature().getName()+
                " method takes: "+(end-start)+" nanoSec");
        return  result;
    }
}
