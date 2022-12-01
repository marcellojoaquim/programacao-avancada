package com.go.learn.repository;

import com.go.learn.model.GoLearnLeadModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoLearnLeadRepository extends JpaRepository<GoLearnLeadModel , Long> {
	
}
