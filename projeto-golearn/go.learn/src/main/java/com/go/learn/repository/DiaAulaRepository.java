package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.DiaAula;

@Repository
public interface DiaAulaRepository extends JpaRepository<DiaAula, Long> {}
