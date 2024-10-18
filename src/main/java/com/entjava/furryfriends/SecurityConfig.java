package com.entjava.furryfriends;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated() // Require authentication for all requests
                )
                .httpBasic(withDefaults()); // Enable Basic Authentication
        return http.build();
    } // POJO plain old java objects
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("daniel")
                        .password("{noop}daniel123")
                        .roles("USER")
                        .build(),
                User.withUsername("thea")
                        .password("{noop}thea123")
                        .roles("USER")
                        .build(),
                User.withUsername("nelson")
                        .password("{noop}nelson123")
                        .roles("USER")
                        .build(),
                User.withUsername("patrick")
                        .password("{noop}patrick123")
                        .roles("USER")
                        .build(),
                User.withUsername("gabrielle")
                        .password("{noop}gabrielle123")
                        .roles("USER")
                        .build(),
                User.withUsername("jose")
                        .password("{noop}jose123")
                        .roles("USER")
                        .build(),
                User.withUsername("ben")
                        .password("{noop}ben10123")
                        .roles("USER")
                        .build()
        );
    }


}