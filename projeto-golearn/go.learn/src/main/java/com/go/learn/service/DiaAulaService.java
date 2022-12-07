package com.go.learn.service;
import org.springframework.stereotype.Service;
import com.go.learn.repository.DiaAulaRepository;


@Service
public class DiaAulaService {
    public final DiaAulaRepository goLearnDiaAulaRepository;

    public DiaAulaService(DiaAulaRepository goLearnDiaAulaRepository){
        this.goLearnDiaAulaRepository = goLearnDiaAulaRepository;
}
}