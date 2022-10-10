package com.semih.service;

import com.semih.repository.IUserProfileRepository;
import com.semih.repository.entity.UserProfile;
import com.semih.utility.ServiceManager;
import org.apache.catalina.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> findAllByUserName(String username) {
        Pageable pageable = Pageable.ofSize(1000);
        return userProfileRepository.findAllByUsername(username, pageable);
    }

    public List<String> findAllEmailList() {
        return userProfileRepository.findAllEmailList();
    }

    public List<UserProfile> findTop1000() {
        Pageable pageable = Pageable.ofSize(1000);
        return userProfileRepository.findAll(pageable).getContent();
    }
}
