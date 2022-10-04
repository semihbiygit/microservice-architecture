package com.semih.services;


import com.semih.dto.request.CompetitionRequestDto;
import com.semih.mapper.ICompetitionMapper;
import com.semih.repository.ICompetitionRepository;
import com.semih.repository.entity.Competition;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService extends ServiceManager<Competition, Long> {
    private final ICompetitionRepository competitionRepository;

    public CompetitionService(ICompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository = competitionRepository;
    }

    public Competition save(CompetitionRequestDto dto) {
        return save(ICompetitionMapper.INSTANCE.toCompetition(dto));
    }
}
