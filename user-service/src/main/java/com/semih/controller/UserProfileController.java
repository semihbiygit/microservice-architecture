package com.semih.controller;

import com.semih.dto.request.CreateNewUserDto;
import com.semih.dto.request.EditProfileRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.UserManagerException;
import com.semih.repository.entity.UserProfile;
import com.semih.services.UserProfileService;
import com.semih.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.semih.constants.ApiUrls.*;


@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping(FIND_ALL_PAGE)
    public ResponseEntity<Page<UserProfile>> findAll(int currentPage, int pageSize, String sortParameter, String sortDirection) {
        return ResponseEntity.ok(userProfileService.findAllPage(currentPage, pageSize, sortParameter, sortDirection));
    }

    @GetMapping(FIND_ALL_SLICE)
    public ResponseEntity<Slice<UserProfile>> findAllSlice(int currentPage, int pageSize, String sortParameter, String sortDirection) {
        return ResponseEntity.ok(userProfileService.findAllSlice(currentPage, pageSize, sortParameter, sortDirection));
    }

    @GetMapping("/find-all-criteria/{page}/{size}/{sortParameter}/{direction}")
    public ResponseEntity<Slice<UserProfile>> findAllCriteria(@PathVariable int page,
                                                              @PathVariable int size,
                                                              @PathVariable String sortParameter,
                                                              @PathVariable String direction) {
        return ResponseEntity.ok(userProfileService.findAllSlice(page, size, sortParameter, direction));

    }

    @GetMapping("/redis")
    @Cacheable(value = "redis-test")
    public String redisTest(String message) {
        try {
            Thread.sleep(3000);
            return "Your message... :" + message;
        } catch (Exception e) {
            return "ERROR";
        }
    }

    @GetMapping("/get-all-cache")
    public List<UserProfile> getAllCache() {
        log.info("Fetching all users....");
        return userProfileService.getAllCache();
    }

    @GetMapping("/clear-cache")
    public void clearCache(String key, String parameter) {
        userProfileService.clearCache(key, parameter);
    }

}
