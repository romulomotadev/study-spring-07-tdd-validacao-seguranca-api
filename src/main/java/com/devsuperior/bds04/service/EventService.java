package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repository.CItyRepository;
import com.devsuperior.bds04.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    // ========== DEPENDENCIAS ============

    @Autowired
    public EventRepository eventRepository;
    @Autowired
    public CItyRepository cityRepository;


    // ======== GET ===========

    //FIND ALL
    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable).map(EventDTO::new);
    }


    // ======== POST ===========

    @Transactional
    public EventDTO save(EventDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setUrl(dto.getUrl());

        City city;
        city = cityRepository.getReferenceById(dto.getCityId());
        event.setCity(city);

        eventRepository.save(event);
        return new EventDTO(event);
    }


}
