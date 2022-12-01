package com.go.learn.service;
import org.springframework.stereotype.Service;
import com.go.learn.repository.GoLearnDiaAulaRepository;


@Service
public class GoLearnDiaAulaService {
    public final GoLearnDiaAulaRepository goLearnDiaAulaRepository;

    public GoLearnDiaAulaService(GoLearnDiaAulaRepository goLearnDiaAulaRepository){
        this.goLearnDiaAulaRepository = goLearnDiaAulaRepository;
}
}