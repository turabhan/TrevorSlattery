package ru.urfu.trevorslattery.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer.withDefaults())

                .authorizeHttpRequests(auth -> auth
                        // Разрешаем статику и общие страницы
                        .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()

                        // Ограничения по ролям (Spring автоматически добавит префикс ROLE_)
                        .requestMatchers("/products/create", "/products/delete/**").hasRole("ADMIN")
                        .requestMatchers("/cart/**").hasRole("USER")

                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
                )

                // Настройка формы логина
                .formLogin(form -> form
                        .loginPage("/login")               // Кастомная страница логина
                        .defaultSuccessUrl("/products", true) // Куда редиректить после входа
                        .permitAll()
                )

                // Настройка выхода
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true) // Удалить сессию
                        .clearAuthentication(true)   // Очистить данные авторизации
                        .permitAll()
                );

        return http.build();
    }
}