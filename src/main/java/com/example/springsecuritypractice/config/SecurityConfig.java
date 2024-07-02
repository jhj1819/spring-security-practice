package com.example.springsecuritypractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login").permitAll() //메인페이지, login화면에 모두 접근 가능
                        .requestMatchers("/admin").hasRole("ADMIN") // ADMIN 권한이 있을때만 접근하도록
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // 여러개의 권한이 있을때, 사용자 ID가 다를 수 있으므로 **와일드카드 사용
                        .anyRequest().authenticated() //나머지 경우 로그인한 사용자만 가능하도록
                );


        return http.build();
    }
}
