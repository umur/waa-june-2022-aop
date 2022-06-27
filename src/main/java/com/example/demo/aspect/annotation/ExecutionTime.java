package com.example.demo.aspect.annotation;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExecutionTime {
}
