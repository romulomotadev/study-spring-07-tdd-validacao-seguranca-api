package com.devsuperior.bds04.service;

import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.projection.UserDetailsProjection;
import com.devsuperior.bds04.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    //===== USER DETAIL SERVICE =======

    @Autowired
    UserRepository userRepository;


    //===== USER DETAIL SERVICE =======
    //===== VERIFICAÇÃO USUARIO NO BANCO : EMAIL =======

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
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
