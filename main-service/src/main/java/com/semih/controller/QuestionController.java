package com.semih.controller;

import com.semih.dto.request.QuestionAddRequestDto;
import com.semih.dto.request.QuestionRequestDto;
import com.semih.exception.ErrorType;
import com.semih.exception.MainManagerException;
import com.semih.repository.entity.Questions;
import com.semih.services.QuestionsService;
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
@RequestMapping(BASE_URL + MAIN + QUESTION)
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionsService questionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createQuestion(@RequestBody @Valid QuestionAddRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if (userId.isEmpty()) {
                throw new MainManagerException(ErrorType.INVALID_TOKEN);
            }
            questionService.addQuestion(dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
