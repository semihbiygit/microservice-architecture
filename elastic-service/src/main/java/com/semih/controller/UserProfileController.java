package com.semih.controller;

import com.semih.repository.entity.UserProfile;
import com.semih.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.semih.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + USER)
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfile userProfile) {
        userProfileService.save(userProfile);
        return ResponseEntity.ok(true);

    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UserProfile userProfile) {
        userProfileService.update(userProfile);
        return ResponseEntity.ok(true);

    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody UserProfile userProfile) {
        userProfileService.delete(userProfile);
        return ResponseEntity.ok(true);

    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<Iterable<UserProfile>> findAll() {
        Long start = System.currentTimeMillis();
        Iterable<UserProfile> lists = userProfileService.findAll();
        Long end = System.currentTimeMillis();
        System.out.println("Time Elastic....: " + (end - start));
        return ResponseEntity.ok(lists);
    }


}
