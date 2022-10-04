package com.semih.controller;

import com.semih.dto.request.CompetitionRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.MainManagerException;
import com.semih.repository.entity.Competition;
import com.semih.services.CompetitionService;
import com.semih.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static com.semih.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + COMPETITION)
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Competition> createCompetition(@RequestBody @Valid CompetitionRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty()) {
                throw new MainManagerException(ErrorType.INVALID_TOKEN);
            }
            competitionService.save(dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
