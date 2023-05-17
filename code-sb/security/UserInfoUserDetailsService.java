package com.example.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
