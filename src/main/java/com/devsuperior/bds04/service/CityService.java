package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repository.CItyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    //===== DEPENDENCIAS =====

    @Autowired
    private CItyRepository repository;


    //===== GET =====

    //FIND ALL SORTED NAME
    @Transactional(readOnly = true)
    public List<CityDTO> findAllCitiesSortedName(){
        List<City> cities = repository.findAllByOrderByNameAsc();
        return cities.stream().map(CityDTO::new).toList();
    }

}
