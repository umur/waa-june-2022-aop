package edu.miu.springdata.controller;


import edu.miu.springdata.service.ExecutionTime;
import edu.miu.springdata.service.RequestInf;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aop")
@CrossOrigin
public class AspectController {

    //http://localhost:8080/aop/ExecutionTime
    @ExecutionTime
    @GetMapping("/ExecutionTime")
    public void testExecutionTime(){

    }

    //http://localhost:8080/aop/AOP-IS-AWESOME
    @RequestInf
    @GetMapping("/AOP-IS-AWESOME")
    public void testRequestInf(){

    }

    //http://localhost:8080/aop/testRequestInf
    @RequestInf
    @GetMapping("/testRequestInf")
    public void testRequestInf2(){

    }
}
