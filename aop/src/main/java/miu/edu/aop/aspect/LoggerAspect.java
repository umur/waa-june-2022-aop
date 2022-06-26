package miu.edu.aop.aspect;

import miu.edu.aop.domain.ActivityLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    ActivityLog activityLog;
//  @Pointcut("@annotation(com.example.demo.aspect.annotations.LogMe)")
//  public void a() {}  //always empty and void

    //  @After("a()")// one way
    @After("@annotation(com.example.demo.aspect.annotations.LogMe)")  //this is another way
    public void log(JoinPoint joinPoint) {
        activityLog.setOperation(joinPoint.getSignature().getName()); //setting the operation
//    System.out.println("Method name: " + joinPoint.getSignature().getName());

    }


}
