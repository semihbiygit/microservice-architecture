package com.semih.utility;

import com.semih.manager.IUserManager;
import com.semih.repository.entity.UserProfile;
import com.semih.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImportData {
    private final IUserManager userManager;
    private final UserProfileService userProfileService;

    @PostConstruct
    public void init() {
        List<UserProfile> lists = userManager.findAll().getBody();
        userProfileService.saveAll(lists);
    }
}
