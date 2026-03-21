package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.projection.UserDetailsProjection;
import com.devsuperior.bds04.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    //===== DEPENDENCIAS =====

    @Autowired
    UserRepository repository;


    //===== METODOS =======

    //USUARIO LOGADO
    protected User authenticated(){
        try{

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return repository.findByEmail(username).get();

        } catch (Exception e) {
            throw new UsernameNotFoundException("Email not found");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO getMe(){
        User user = authenticated();
        return new UserDTO(user);
    }


    //===== USER DETAIL SERVICE =======
    //VERIFICAÇÃO USUARIO NO BANCO : EMAIL
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if(result.isEmpty()){ throw new UsernameNotFoundException(username);}

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getFirst().getPassword());

        for(UserDetailsProjection projections : result){
            user.addRole(new Role(projections.getId(), projections.getAuthority()));
        }

        return user;
    }
}
