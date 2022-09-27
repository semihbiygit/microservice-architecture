package com.semih.services;

import com.semih.dto.request.DoLoginRequestDto;
import com.semih.dto.request.RegisterRequestDto;
import com.semih.repository.IAuthRepository;
import com.semih.repository.entity.Auth;
import com.semih.repository.enums.Roles;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }

    public Auth register(RegisterRequestDto dto) {
        Auth auth;
        auth = Auth.builder()
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
        if (dto.getRoleAdminPassword() != null)
            if (dto.getRoleAdminPassword().equals("admin"))
                auth.setRole(dto.getRole() == null ? Roles.ADMIN : dto.getRole());
            else {
                auth.setRole(Roles.USER);
            }
        return authRepository.save(auth);
    }

    public boolean doLogin(DoLoginRequestDto dto) {
        return authRepository.isExists(dto.getUsername(), dto.getPassword());
    }

}

