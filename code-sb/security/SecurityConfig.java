package com.example.security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
        //        UserDetails admin = User.withUsername("Basant")
        //                .password(encoder.encode("Pwd1"))
        //                .roles("ADMIN")
        //                .build();
        //        UserDetails user = User.withUsername("John")
        //                .password(encoder.encode("Pwd2"))
        //                .roles("USER","ADMIN","HR")
        //                .build();
        //        return new InMemoryUserDetailsManager(admin, user);
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/products/welcome", "/products/new").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/products/**")
                .authenticated().and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}

