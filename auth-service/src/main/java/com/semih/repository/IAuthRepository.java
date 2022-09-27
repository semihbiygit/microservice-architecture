package com.semih.repository;

import com.semih.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {

    /**
     * username can not be case-sensitive (semih,Semih,SEMİH)
     * password must be case-sensitive (1semih',3.Semih,16!SEMIH!)
     */
    Optional<Auth> findOptionalByUsernameIgnoreCaseAndPassword(String username, String password);

    @Query("select COUNT(a)>0 from Auth a where UPPER(a.username) =UPPER(?1) and a.password = ?2")
    Boolean isExists(String username, String password);

}

