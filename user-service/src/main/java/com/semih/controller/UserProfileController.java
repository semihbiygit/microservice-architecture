package com.semih.controller;

import com.semih.dto.request.CreateNewUserDto;
import com.semih.dto.request.EditProfileRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.UserManagerException;
import com.semih.repository.entity.UserProfile;
import com.semih.services.UserProfileService;
import com.semih.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.semih.constants.ApiUrls.*;


@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    @GetMapping("/test")
    public String getTestString() {
        return "User test";
    }

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
        try {
            Optional<Long> authId = jwtTokenManager.getUserId(dto.getToken());
            if (authId.isEmpty())
                throw new UserManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(userProfileService.updateUserProfile(dto, authId.get()));
        } catch (Exception exception) {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<Page<UserProfile>> findAll(int currentPage, int pageSize, String sortParameter, String sortDirection) {
        return ResponseEntity.ok(userProfileService.findAllPage(currentPage, pageSize, sortParameter, sortDirection));
    }
}
