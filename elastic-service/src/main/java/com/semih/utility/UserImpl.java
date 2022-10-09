package com.semih.utility;

import com.semih.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserImpl {

    private final UserProfileService userProfileService;

}
