package at.technikum.todoapp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        System.out.println("Check Token here!");
        System.out.println(request.getHeader("Authorization"));

        // check JWT, if valid read user data and create authentication

        if (null == request.getHeader("Authorization")) {
            filterChain.doFilter(request, response);
            return;
        }

        String userId = request
                .getHeader("Authorization")
                .replace("Bearer ", "");
        Authentication authentication = new UserPrincipalAuthenticationToken(
                new UserPrincipal(
                        userId,
                        "testuser",
                        "",
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request, response);
    }
}
