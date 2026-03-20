package com.devsuperior.bds04.repository;

import com.devsuperior.bds04.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CItyRepository extends JpaRepository<City, Long> {

    //BUSCA CIDADES ORDENADAS POR NOME
    List<City> findAllByOrderByNameAsc();
}
