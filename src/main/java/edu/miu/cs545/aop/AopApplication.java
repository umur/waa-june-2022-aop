package edu.miu.cs545.aop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopApplication {
	@Bean
	public ModelMapper mapper(){
		System.out.println("Here");
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
