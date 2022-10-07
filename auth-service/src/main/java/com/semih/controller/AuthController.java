package com.semih.controller;

import com.semih.dto.request.DoLoginRequestDto;
import com.semih.dto.request.RegisterRequestDto;
import com.semih.repository.entity.Auth;
import com.semih.services.AuthService;
import com.semih.config.security.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.semih.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;

    // http://localhost:9090/v1/api/auth/test
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public String getTestString() {
        return "Auth test";
    }

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        authService.register(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody @Valid DoLoginRequestDto dto) {
        Optional<Auth> auth = authService.doLogin(dto);
        if (auth.isPresent()) {
            String token = jwtTokenManager.createToken(auth.get().getId()).get();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Login failed");
    }


}
