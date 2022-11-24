package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnDiaAula;

@Repository
public interface GoLearnDiaAulaRepository extends JpaRepository<GoLearnDiaAula, Long> {}
