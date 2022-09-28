package com.semih.services;

import com.semih.dto.request.CreateNewUserDto;
import com.semih.repository.IUserProfileRepository;
import com.semih.repository.entity.UserProfile;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(CreateNewUserDto dto) {
        return save(UserProfile.builder()
                .authId(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }
}
