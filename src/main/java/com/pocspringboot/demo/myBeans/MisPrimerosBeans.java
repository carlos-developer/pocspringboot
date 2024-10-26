package com.pocspringboot.demo.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MisPrimerosBeans {

    @Bean
    MiBean crearMiBean() {
        return new MiBean();
    }
}
