package com.example.demo.aspect;

import com.example.demo.entity.ActivityLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
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

  @AfterThrowing(pointcut = "@annotation(org.springframework.web.bind.annotation.PostMapping)", throwing = "error")
  public void exceptionHandling(Throwable error) {
    System.out.println("Exception: " + error);
  }

}
