package com.semih.services;

import com.semih.dto.request.CreateNewUserDto;
import com.semih.dto.request.EditProfileRequestDto;
import com.semih.mapper.IUserProfileMapper;
import com.semih.repository.IUserProfileRepository;
import com.semih.repository.entity.UserProfile;
import com.semih.utility.ServiceManager;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Boolean updateUserProfile(EditProfileRequestDto dto, Long authId) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findOptionalByAuthId(authId);
        if (optionalUserProfile.isEmpty()) return false;
        try {
            userProfile.setId(optionalUserProfile.get().getId());
            update(userProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortParameter);
        Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
        return userProfileRepository.findAll(pageable);
    }

    public Slice<UserProfile> findAllSlice(int currentPage, int pageSize, String sortParameter, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortParameter);
        Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
        return userProfileRepository.findAll(pageable);
    }
}
