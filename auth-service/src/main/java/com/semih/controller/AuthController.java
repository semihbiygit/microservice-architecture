package com.semih.controller;

import com.semih.dto.request.DoLoginRequestDto;
import com.semih.dto.request.RegisterRequestDto;
import com.semih.repository.entity.Auth;
import com.semih.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static com.semih.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        authService.register(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody @Valid DoLoginRequestDto dto) {
        Optional<Auth> auth = authService.doLogin(dto);
        if (auth.isPresent()) {
            String token = "token: TKN" + auth.get().getId().toString() + "X16S7";
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Login failed");
    }


}
