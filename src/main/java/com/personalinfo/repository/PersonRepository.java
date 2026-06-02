package com.personalinfo.repository;

import com.personalinfo.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonalInfo, Long> {
    Optional<PersonalInfo> findByEmail(String email);
}
