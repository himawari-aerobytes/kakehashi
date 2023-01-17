package com.himawari.kakehashi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.himawari.kakehashi.constants.ManagementCode.ADMIN;
import static com.himawari.kakehashi.constants.ManagementCode.JSESSIONID;

@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/css/**", "/fonts/**", "/js/**")
                .permitAll()
                .mvcMatchers("/", "/login")
                .permitAll()
                .mvcMatchers("/admin")
                .hasRole(ADMIN)
                .anyRequest()
                .authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome")
                .and()

                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies(JSESSIONID)
                .and()

                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()

                .oauth2Login()
                .loginPage("/login").permitAll()
                .redirectionEndpoint()
                .baseUri("/login/code/**");

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
