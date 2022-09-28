package com.semih.controller;

import com.semih.dto.request.CreateNewUserDto;
import com.semih.dto.request.EditProfileRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.UserManagerException;
import com.semih.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.semih.constants.ApiUrls.*;


@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_NEW_USER)
    public ResponseEntity<Boolean> CreateNewUser(@RequestBody @Valid CreateNewUserDto dto) {
        try {
            userProfileService.createUserProfile(dto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.USER_CANNOT_CREATE);
        }
    }

    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto dto) {
        if (dto.getToken() == null)
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        try {
            Long authId = Long.parseLong(dto.getToken().substring(3, dto.getToken().indexOf("X")));
            return ResponseEntity.ok(userProfileService.updateUserProfile(dto, authId));
        } catch (Exception exception) {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
