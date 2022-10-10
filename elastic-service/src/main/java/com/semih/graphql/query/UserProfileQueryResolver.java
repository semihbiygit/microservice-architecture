package com.semih.graphql.query;

import com.semih.repository.entity.UserProfile;
import com.semih.service.UserProfileService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileQueryResolver implements GraphQLQueryResolver {

    private final UserProfileService userProfileService;

    public Iterable<UserProfile> findAll() {
        return userProfileService.findTop1000();
    }

    public List<UserProfile> findAllByUsername(String username) {
        return userProfileService.findAllByUserName(username);
    }

    public List<String> findAllEmailList() {
        return userProfileService.findAllEmailList();
    }

}
