package com.melt.grub.service;

import com.google.common.collect.ImmutableList;
import com.melt.grub.domain.Role;
import com.melt.grub.domain.User;
import com.melt.grub.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("user %s was not found", username)));
    }

    @PostConstruct
    public void init() {
        if (!userRepo.findByUsername("admin").isPresent()) {

            User user = User.builder()
                    .username("admin")
                    .password("$2a$10$Zzb1aoyyk0cG5r4xHBmQM.umVIoNObhzgIQEr6jORsWfAYJwCbI/y")
                    .authorities(ImmutableList.of(Role.USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
            userRepo.save(user);
        }
    }
}
