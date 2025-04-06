package com.gcu.carstoreapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.carstoreapplication.security.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MyUserDetailsService userDetailsService;

    public SecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login/doLogin")
                .defaultSuccessUrl("/", true) // Redirect to /success after login
                .failureUrl("/login?error=true") // Redirect to /login with error on failure
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true") // Redirect to /login after logout
                .permitAll()
            );

        return http.build();
    }

  //  @Bean
    //public PasswordEncoder passwordEncoder() {
      //  return new BCryptPasswordEncoder();
    //}
    // Uncomment the above line and comment the below line to use BCryptPasswordEncoder
@Bean
public PasswordEncoder passwordEncoder() {
    return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
}
}