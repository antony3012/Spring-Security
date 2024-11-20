package com.springsecurity.config;

import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

           return http
                       .csrf(AbstractHttpConfigurer::disable)//Cross Site Request Forgery
//                        .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())//any request should authenticate
                   .authorizeHttpRequests(authorize -> authorize
                           .requestMatchers("/hi").authenticated() // Require authentication for /hi
                           .requestMatchers("/**").permitAll() // Allow access to public endpoints
                           .anyRequest().authenticated() // Require authentication for any other requests
                   )
//                        .formLogin(Customizer.withDefaults())//spring boot login page
                        .httpBasic(Customizer.withDefaults())//for post man
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("mark")
//                .password("m@123")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("vinoth")
//                .password("v@123")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //no passsword enode
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //for password encode
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }
}
