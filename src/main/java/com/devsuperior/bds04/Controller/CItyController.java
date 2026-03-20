package com.devsuperior.bds04.Controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CItyController {

    //===== DEPENDENCIAS ======
    @Autowired
    private CityService service;

    //===== GET ======
    //FIND ALL SORTED NAME
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllCitiesSortedName(){
        List<CityDTO> cities = service.findAllCitiesSortedName();
        return ResponseEntity.ok(cities);
    }

}

