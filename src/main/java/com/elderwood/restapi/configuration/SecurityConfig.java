package com.elderwood.restapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import com.elderwood.restapi.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CorsConfig corsConfig;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // @Bean
    // public AuthenticationManager authenticationManager(
    //         UserDetailsService userDetailsService,
    //         PasswordEncoder passwordEncoder) {
    //     DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //     authenticationProvider.setUserDetailsService(userDetailsService);
    //     authenticationProvider.setPasswordEncoder(passwordEncoder);

    //     return new ProviderManager(authenticationProvider);
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return new UserDetailsService();
    // }

    // @Bean
    // UserDetailsManager user(DataSource dataSource) {
    //     UserDetails user = User.builder()
    //             .username("Tazman551")
    //             .password(passwordEncoder().encode("test1234"))
    //             .roles("USER")
    //             .build();
    //     UserDetails admin = User.builder()
    //             .username("admin")
    //             .password(passwordEncoder().encode("1234"))
    //             .roles("USER", "ADMIN")
    //             .build();
    //     JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    //     users.createUser(user);
    //     users.createUser(admin);
    //     return users;
    // }

}