/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelo.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Carmelo Marin Abrego
 */
public class Hello {

    @Bean
    public HelloService helloBean() {
        return new HelloServiceImpl();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Hello.class);

        HelloService hs = applicationContext.getBean(HelloService.class);

        System.out.println(hs.saludar());
    }

}
