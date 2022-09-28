package com.semih.repository;

import com.semih.repository.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipationRepository extends JpaRepository<Participation, Long> {
}
