package com.devsuperior.bds04.Controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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


    //===== POST ======
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO city){
        CityDTO dto = service.insert(city);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

