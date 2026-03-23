package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.EventDTO;
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
    public EventRepository repository;


    // ======== GET ===========

    //FIND ALL
    @Transactional
    public Page<EventDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(EventDTO::new);
    }


}
