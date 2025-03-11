
package com.egg.biblioteca;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadWeb {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers("/css/", "/js/", "/img/", "/**").permitAll())
              .formLogin(
                (form) -> form // Configura el formulario de inicio de sesión
                    .loginPage("/login") // URL de la página de inicio de sesión.
                    .loginProcessingUrl("/logincheck") // Envía datos de inicio de sesión
                    .usernameParameter("email") // Nombre de los campos en el formulario de inicio de sesión
                    .passwordParameter("password")
                    .defaultSuccessUrl("/inicio") // URL a la que se redirige el usuario después de sesión exitosa.
                    .permitAll())
              .logout((logout) -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
            ).csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}

