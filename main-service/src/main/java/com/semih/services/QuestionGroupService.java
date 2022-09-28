package com.semih.services;


import com.semih.repository.IQuestionGroupRepository;
import com.semih.repository.entity.QuestionGroup;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionGroupService extends ServiceManager<QuestionGroup,Long> {
    private final IQuestionGroupRepository questionGroupRepository;

    public QuestionGroupService(IQuestionGroupRepository questionGroupRepository) {
        super(questionGroupRepository);
        this.questionGroupRepository = questionGroupRepository;
    }
}
