package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;

import java.util.HashSet;
import java.util.Set;

public class RoleDTO {

    //===== ATRIBUTOS =======

    private Long id;
    private String authority;


    //===== CONSTRUTORES =======

    public RoleDTO() {
    }


    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }


    public RoleDTO(Role entity) {
        this.id = entity.getId();
        this.authority = entity.getAuthority();
    }


    //===== GETTY | SETTER =======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
