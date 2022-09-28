package com.semih.services;


import com.semih.dto.request.QuestionAddRequestDto;
import com.semih.repository.IQuestionsRepository;
import com.semih.repository.entity.Questions;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService extends ServiceManager<Questions, Long> {
    private final IQuestionsRepository questionsRepository;
    private final AnswersService answersService;

    public QuestionsService(IQuestionsRepository questionsRepository, AnswersService answersService) {
        super(questionsRepository);
        this.questionsRepository = questionsRepository;
        this.answersService = answersService;

    }

    public void addQuestion(QuestionAddRequestDto dto) {
        Questions question = save(Questions.builder()
                .question(dto.getQuestion().getQuestionContent())
                .answerCount(dto.getQuestion().getAnswerCount())
                .time(dto.getQuestion().getTime())
                .ownerId(dto.getQuestion().getCreatorId())
                .build());
        answersService.addQuestionAnswers(dto.getAnswers(), question.getId());

    }


}
