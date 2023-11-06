package com.itheima.springbootautoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootAutoConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootAutoConfigApplication.class, args);
        System.out.println(context.getBean("dispatcherServlet"));
        System.out.println(context.getBean("province"));
    }
}
