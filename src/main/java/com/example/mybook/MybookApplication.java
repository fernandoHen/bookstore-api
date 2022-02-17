package com.example.mybook;

import com.example.mybook.domain.Book;
import com.example.mybook.domain.Category;
import com.example.mybook.repositories.BookRepository;
import com.example.mybook.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class MybookApplication {
//    CommandLineRunner --> ao iniciar a aplicação executa o codigo dentro desse metodo

    public static void main(String[] args) {
        SpringApplication.run(MybookApplication.class, args);
    }
}
