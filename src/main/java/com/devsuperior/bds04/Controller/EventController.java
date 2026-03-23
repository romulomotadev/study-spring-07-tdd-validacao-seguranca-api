package com.devsuperior.bds04.Controller;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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


    //========= POST ============

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<EventDTO> save(@RequestBody @Valid EventDTO eventDTO) {
        EventDTO dto = eventService.save(eventDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
