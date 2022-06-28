package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class HeaderAspect {
    @Autowired
    HttpServletRequest request;

    @Before("execution(edu.miu.waa_lab5_v1.service.IActivityLogService)")
    public void checkHeader(JoinPoint jp) {
        System.out.println(jp);

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println("Header Key: " + key);
            System.out.println("Header value: " + value);
        }
    }
}
