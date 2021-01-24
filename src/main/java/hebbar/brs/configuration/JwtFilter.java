package hebbar.brs.configuration;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hebbar.brs.DTO.ApiError;
import hebbar.brs.services.exception.IllegalValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import hebbar.brs.models.UserDetailsImpl;
import hebbar.brs.services.FetchUserDetailsService;
import hebbar.brs.services.JwtUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private FetchUserDetailsService fetchUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, IllegalValueException {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            final String URL_EMAIL = request.getParameter("email");
            String requestedURI = request.getRequestURI();
            String email = null;
            String jwtToken = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwtToken = authorizationHeader.substring(7);
                email = jwtUtil.extractUsername(jwtToken);
            }
            if (requestedURI.compareTo("/api/authentication/authenticate") != 0) {
                if (email != null &&
                        (email.compareTo(URL_EMAIL) == 0) &&
                        SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.fetchUserDetailService.loadUserByUsername(email);
                    if (jwtUtil.validateToken(jwtToken, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                } else {
                    throw new IllegalValueException("The credentials are wrong");
                }
            }
            filterChain.doFilter(request, response);
        } catch (IllegalValueException e) {
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }
}
