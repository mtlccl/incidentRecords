package com.matheuslemes.diazero.incidentRecords.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfigIncident {
    private static final String[] swaggerList = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/actuator/**",
            "/h2-console/**"
    };
    @Autowired
    private SecurityIncidentFilter securityIncidentFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/incident/create").permitAll()
                            .requestMatchers("incident/update").permitAll()
                            .requestMatchers("incident/delete").permitAll()
                            .requestMatchers("incident/getbyall").permitAll()
                            .requestMatchers("incident/getbyid").permitAll()
                            .requestMatchers("incident/getbyid2").permitAll()
                            .requestMatchers(swaggerList).permitAll();
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(securityIncidentFilter, BasicAuthenticationFilter.class);
        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
