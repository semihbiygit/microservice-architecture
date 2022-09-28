package com.semih.services;

import com.semih.repository.ICompetitionQuestionsRepository;
import com.semih.repository.entity.CompetitionQuestions;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionQuestionsService extends ServiceManager<CompetitionQuestions, Long> {
    private final ICompetitionQuestionsRepository competitionQuestionsRepository;

    public CompetitionQuestionsService(ICompetitionQuestionsRepository competitionQuestionsRepository) {
        super(competitionQuestionsRepository);
        this.competitionQuestionsRepository = competitionQuestionsRepository;
    }
}
