package com.semih.graphql.mutation;

import com.semih.graphql.model.UserProfileInput;
import com.semih.repository.entity.UserProfile;
import com.semih.service.UserProfileService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {

    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput profile) {
        userProfileService.save(UserProfile.builder().
                authId(profile.getAuthId())
                .username(profile.getUsername())
                .name(profile.getName())
                .surname(profile.getSurname())
                .email(profile.getEmail())
                .build());
        return true;
    }
}
