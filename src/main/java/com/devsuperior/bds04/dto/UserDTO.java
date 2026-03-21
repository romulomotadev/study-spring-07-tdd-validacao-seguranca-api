package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    //===== ATRIBUTOS =======

    private int id;
    private String name;
    private String email;
    private String password;


    //===== ATRIBUTOS ASSOCIADOS =======

    private Set<String> roles = new HashSet<String>();


    //===== CONSTRUTORES =======

    public UserDTO() {
    }

    public UserDTO(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //USUARIO LOCADO
    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();

        //OBTER USUARIO LOGADO
        for (GrantedAuthority role : entity.getRoles()) {
            this.roles.add(role.getAuthority());
        }
    }


    //===== GETTY | SETTER =======

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
