package com.semih.services;

import com.semih.config.security.JwtTokenManager;
import com.semih.dto.request.CreateNewUserDto;
import com.semih.dto.request.DoLoginRequestDto;
import com.semih.dto.request.RegisterRequestDto;
import com.semih.manager.IUserManager;
import com.semih.rabbitmq.model.CreateUser;
import com.semih.rabbitmq.producer.CreateUserProducer;
import com.semih.repository.IAuthRepository;
import com.semih.repository.entity.Auth;
import com.semih.repository.enums.Roles;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    private final CreateUserProducer createUserProducer;
    private final JwtTokenManager jwtTokenManager;

    public AuthService(IAuthRepository authRepository, IUserManager userManager, CreateUserProducer createUserProducer, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
        this.createUserProducer = createUserProducer;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Optional<Auth> doLogin(DoLoginRequestDto dto) {
        String encodedPassword = jwtTokenManager.encryptPassword(dto.getPassword());
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(),
                encodedPassword);
    }

    public Auth register(RegisterRequestDto dto) {
        String encodedPassword = jwtTokenManager.encryptPassword(dto.getPassword());
        Auth auth;
        auth = Auth.builder()
                .password(encodedPassword)
                .username(dto.getUsername())
                .role(Roles.USER)
                .build();
        if (dto.getRoleAdminPassword() != null)
            if (dto.getRoleAdminPassword().equals("admin"))
                auth.setRole(dto.getRole() == null ? Roles.ADMIN : dto.getRole());
            else {
                auth.setRole(Roles.USER);
            }
        save(auth);
        /**
         *
         userManager.CreateNewUser(CreateNewUserDto.builder()
         .authId(auth.getId())
         .username(dto.getUsername())
         .email(dto.getEmail())
         .build());
         */

        createUserProducer.sendCreateUserMessage(CreateUser.builder()
                .authId(auth.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(encodedPassword)
                .build());
        return auth;
    }


}

