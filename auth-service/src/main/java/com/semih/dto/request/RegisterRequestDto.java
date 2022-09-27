package com.semih.dto.request;

import com.semih.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    String username;
    @NotNull
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    String password;
    @NotNull
    @Email(message = "Email should be valid")
    String email;
    Roles role;
    String roleAdminPassword;
}
