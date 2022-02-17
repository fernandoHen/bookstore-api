package com.example.mybook.config;

import com.example.mybook.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    //adicionar Configuration - classe de configuraçao
    //profile - aqui se cria o perfil
    //pelo Profile("test") o spring entende que o perfil ativo é o de teste (application-test)

    @Autowired
    private DBServices dbServices;

    //metodo para instanciar o banco de dados
    //Bean - para subir o metodo quando tiver o perfil de teste

    @Bean
    public void insDatabase() {
        this.dbServices.insDataBate();
    }


}
