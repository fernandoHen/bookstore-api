package com.example.mybook.repositories;

import com.example.mybook.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface repository
@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {
    //jpaRepository<classe implementada no repositorio, tipo da variavel primitica de chave primaria>


}
