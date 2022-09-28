package com.semih.repository;

import com.semih.repository.entity.DegreeHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDegreeHoldersRepository extends JpaRepository<DegreeHolders, Long> {
}
