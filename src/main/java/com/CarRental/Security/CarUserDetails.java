package com.CarRental.Security;

import com.CarRental.Entity.User;
import com.CarRental.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CarUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionaluser = userRepository.findById(username);
        User user = new User();
        if(optionaluser.isPresent()) {
            user = optionaluser.get();
        }
        Set<String> roles = new HashSet<>();
        roles.add(user.getRole());

        //converting the role to authorities
        Set<GrantedAuthority> authorities = roles.stream().map(r->new SimpleGrantedAuthority(r.describeConstable().get())).collect(Collectors.toSet());


        return new org.springframework.security.core.userdetails.User(user.getUserEmail(),user.getUserPassword(),authorities);
    }
}
