package com.go.learn.service;

import com.go.learn.repository.GoLearnFeriadoRepository;
import org.springframework.stereotype.Service;

@Service
public class GoLearnFeriadoService {

    public final GoLearnFeriadoRepository goLearnFeriadoRepository;

    public GoLearnFeriadoService(GoLearnFeriadoRepository goLearnFeriadoRepository) {
        this.goLearnFeriadoRepository = goLearnFeriadoRepository;
    }
}
