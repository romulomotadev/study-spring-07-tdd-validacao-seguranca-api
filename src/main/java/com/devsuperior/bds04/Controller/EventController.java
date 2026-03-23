package com.devsuperior.bds04.Controller;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    //====== DEPENDENCIAS ======

    @Autowired
    private EventService eventService;


    //========= GET ============

    //FIND ALL PAGED
    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAll( Pageable pageable) {
        Page<EventDTO> events = eventService.findAll(pageable);
        return ResponseEntity.ok(events);
    }

}
