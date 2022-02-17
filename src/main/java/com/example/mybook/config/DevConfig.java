package com.example.mybook.config;

import com.example.mybook.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.validation.Valid;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBServices dbServices;

    //instancia o bando de dados
    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String strategy;

    @Bean
    public Boolean insDataBaseDev() {
        if (strategy.equals("create")) {
            this.dbServices.insDataBate();
        }
        return false;
    }

}
