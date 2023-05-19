package com.example.javaproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class LoginController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }/*//        http.authorizeHttpRequests().requestMatchers("/user").hasAuthority("user").and().httpBasic(withDefaults());

//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());

        http
                .csrf().disable()
                .authorizeRequests().requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login");*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {



        http
                .authorizeRequests().requestMatchers("/login")
                .permitAll()
                .requestMatchers("/user")
                .hasAuthority("user")
                .requestMatchers("/admin")
                .hasAuthority("admin")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}