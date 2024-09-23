package com.danielpyld.mongo.service;

import com.danielpyld.mongo.entities.Account;
import com.danielpyld.mongo.entities.UserPrincipal;
import com.danielpyld.mongo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account Not Found with email: " + email));

        return new UserPrincipal(user);
    }

}