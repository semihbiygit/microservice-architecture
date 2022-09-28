package com.semih.services;


import com.semih.dto.request.AnswersRequestDto;
import com.semih.repository.IAnswersRepository;
import com.semih.repository.entity.Answers;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswersService extends ServiceManager<Answers, Long> {
    private final IAnswersRepository answersRepository;

    public AnswersService(IAnswersRepository answersRepository) {
        super(answersRepository);
        this.answersRepository = answersRepository;
    }

    public void addQuestionAnswers(List<AnswersRequestDto> dto, Long questionId) {
        dto.forEach(x -> {
            Answers answers = Answers.builder()
                    .answer(x.getAnswerContent())
                    .isTrue(x.getIsAnswerCorrect())
                    .questionId(questionId)
                    .build();
            save(answers);
        });
    }

}
