package com.semih.utility;

import com.semih.dto.request.RegisterRequestDto;
import com.semih.repository.enums.Roles;
import com.semih.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
@RequiredArgsConstructor
public class AuthImpl {
    private final AuthService authService;

    //@PostConstruct
    public void init() {
        authService.register(RegisterRequestDto.builder()
                .username("admin")
                .email("admin@admin.com")
                .password("123456")
                .role(Roles.ADMIN)
                .roleAdminPassword("admin")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("serpil")
                .email("serpil@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("deniz")
                .email("deniz@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("bahar")
                .email("bahat@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("tekin")
                .email("tekin@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("berk")
                .email("berk@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("cansu")
                .email("cansu@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("zeynep")
                .email("zeynep@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("akın")
                .email("akın@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("ahmet")
                .email("ahmet@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("ceren")
                .email("ceren@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("ersin")
                .email("ersin@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("ferhat")
                .email("ferhat@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("gunes")
                .email("gunes@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("hakkı")
                .email("hakki@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("kerim")
                .email("kerim@uygulama.com")
                .password("123456")
                .role(Roles.USER)
                .build());
    }
}
