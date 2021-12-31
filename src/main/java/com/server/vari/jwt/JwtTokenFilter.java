package com.server.vari.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override // Request로 들어오는 Jwt Token의 유효성을 검증하는 filter를 filterchain에 등록
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenProvider.resolveToken(request);

        if (token != null && jwtTokenProvider.validateToken(token)) { //token 검증
            Authentication authentication = jwtTokenProvider.getAuthentication(token); //인증 객체 생성
            SecurityContextHolder.getContext().setAuthentication(authentication); // SecurityContextHolder에 인증 객체 저장
        }

        filterChain.doFilter(request, response);
    }
}
