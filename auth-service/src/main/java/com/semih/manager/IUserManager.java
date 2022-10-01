package com.semih.manager;

import com.semih.dto.request.CreateNewUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @FeignClient annotation is used to create a proxy to the service that we want to call.
 * It is necessary to give the url of the controller you want to reach.
 * All feign operations must be given unique naming.
 */

@FeignClient(url = "${raceapplication.url.user}/v1/api/user", name = "user-service-userprofile", decode404 = true)
public interface IUserManager {

    @PostMapping("/create-new-user")
    ResponseEntity<Boolean> CreateNewUser(CreateNewUserDto dto);

}
