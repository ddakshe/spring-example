package com.example.spring.config;

import com.example.spring.JwtAuthorizationFilter;
import com.example.spring.jwt.JwtAuthenticationEntryPoint;
import com.example.spring.jwt.JwtAuthenticationManager;
import com.example.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access-token-valid-time}")
    private long tokenValidTime;

    public SecurityConfiguration(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .addFilter(corsFilter())
                .csrf().disable()
                .formLogin().disable().headers(config -> config.frameOptions().disable())
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests((auth) ->
                        auth.antMatchers("/", "/auth/**").permitAll()
                                .antMatchers("/h2", "/h2-console").permitAll()
                                .anyRequest().authenticated())
                .addFilterBefore(new JwtAuthorizationFilter(userRepository, secret), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(configurer ->
                        configurer.authenticationEntryPoint(jwtAuthenticationEntryPoint));
        return http.build();
    }



    @Bean
    public AuthenticationManager authenticationManager() {
        return new JwtAuthenticationManager(userRepository, passwordEncoder);
    }


    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //config.addAllowedOrigin("*"); // java.lang.IllegalArgumentException: When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
        config.addAllowedOriginPattern("*"); // e.g. http://domain1.com
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
