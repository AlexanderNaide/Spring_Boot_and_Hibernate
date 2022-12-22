package ru.gb.spring_boot_and_hibernate.api;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class CustomerFilter extends OncePerRequestFilter/*implements Filter*/ {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("\n\nВходящие данные:\n");
        System.out.println("URL:");
        System.out.println(request.getRequestURI());
        System.out.println("Parameters:");
        request.getParameterMap().forEach((a, e) -> System.out.println("[" + a + " " + Arrays.toString(e) + "]"));

        filterChain.doFilter(request, response);
    }
}