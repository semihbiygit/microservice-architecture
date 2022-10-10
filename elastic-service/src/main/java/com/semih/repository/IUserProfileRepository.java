package com.semih.repository;

import com.semih.repository.entity.UserProfile;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile, Long> {

    //  @Query("select COUNT(a)>0 from UserProfile a where  a.authId = ?1")
    //  Boolean isExists(Long authid);

    //  Optional<UserProfile> findOptionalByAuthId(Long authId);

    List<UserProfile> findAllByUsername(String username, Pageable pageable);

    @Query("select u.email from UserProfile u limit 1000")
    List<String> findAllEmailList();

}

