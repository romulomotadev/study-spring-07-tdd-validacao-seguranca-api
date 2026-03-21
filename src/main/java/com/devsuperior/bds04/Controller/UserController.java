package com.devsuperior.bds04.Controller;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    //=======DEPENDENCIAS ========

    private final UserService service;


    //=======DEPENDENCIAS ========

    public UserController(UserService service) {
        this.service = service;
    }


    //=========== GET ==============

    //USUARIO LOGADO
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> findMe() {
        UserDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }
}
