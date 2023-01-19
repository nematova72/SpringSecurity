package com.example.SpringSecurity.security;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceIml")
public class UserDetailServiceIml implements UserDetailsService {

    private final UserRepository userRepository;

@Autowired
    public UserDetailServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email).orElseThrow(() ->
               new UsernameNotFoundException("User does not exist"));
       return SecurityUser.fromUser(user);
    }
}
