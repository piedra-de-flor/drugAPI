package com.example.drugAPI.domains.drugs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    Optional<Drug> findByDrugName(String drugName);
}
