package com.semih.repository;

import com.semih.repository.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswersRepository extends JpaRepository<Answers, Long> {
}
