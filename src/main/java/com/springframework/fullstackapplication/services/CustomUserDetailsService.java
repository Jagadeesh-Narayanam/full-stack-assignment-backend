package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.CustomUserDetails;
import com.springframework.fullstackapplication.model.User;
import com.springframework.fullstackapplication.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("No user found with that username");
        }
        return new CustomUserDetails(user);
    }
}
