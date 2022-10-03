package com.semih.controller;

import com.semih.dto.request.QuestionGroupRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.MainManagerException;
import com.semih.repository.entity.QuestionGroup;
import com.semih.services.QuestionGroupService;
import com.semih.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.semih.constants.ApiUrls.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL + MAIN + QUESTION_GROUP)
@RequiredArgsConstructor
public class QuestionGroupController {

    private final JwtTokenManager jwtTokenManager;
    private final QuestionGroupService questionGroupService;

    @PostMapping(CREATE)
    public ResponseEntity<QuestionGroup> createQuestionGroup(@RequestBody @Valid QuestionGroupRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if (userId.isEmpty())
                throw new MainManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(questionGroupService.save(QuestionGroup.builder()
                    .groupName(dto.getGroupName())
                    .build()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
