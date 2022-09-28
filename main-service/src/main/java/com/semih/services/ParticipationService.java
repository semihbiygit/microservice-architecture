package com.semih.services;


import com.semih.repository.IParticipationRepository;
import com.semih.repository.entity.Participation;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService extends ServiceManager<Participation, Long> {
    private final IParticipationRepository participationRepository;

    public ParticipationService(IParticipationRepository participationRepository) {
        super(participationRepository);
        this.participationRepository = participationRepository;
    }
}
