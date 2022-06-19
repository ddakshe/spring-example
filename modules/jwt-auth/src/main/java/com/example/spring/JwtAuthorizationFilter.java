package com.example.spring;

import com.example.spring.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUserRepository jwtUserRepository;
    private final String secret;

    public JwtAuthorizationFilter(JwtUserRepository jwtUserRepository, String secret) {
        this.jwtUserRepository = jwtUserRepository;
        this.secret = secret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String authorization = request.getHeader("Authorization");
        String jwtPrefix = "Bearer ";
        if (authorization != null && authorization.startsWith(jwtPrefix)) {
            String token = authorization.replace(jwtPrefix, "");

            try {
                Claims claims = Jwts.parser().setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody();
                User user = jwtUserRepository.findByEmail(claims.getSubject());
                UserDetails userDetails = new SpringUserDetails(user.getId(), user.getEmail(), user.getName(), user.getRole());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(userDetails);
                SecurityContextHolder.getContext().setAuthentication(authentication);


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        chain.doFilter(request, response);

    }

}
