package com.semih.repository;

import com.semih.repository.entity.UserProfile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile, Long> {

    //  @Query("select COUNT(a)>0 from UserProfile a where  a.authId = ?1")
    //  Boolean isExists(Long authid);

    //  Optional<UserProfile> findOptionalByAuthId(Long authId);

}

