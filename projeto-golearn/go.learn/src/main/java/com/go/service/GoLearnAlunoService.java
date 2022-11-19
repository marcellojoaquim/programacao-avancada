package com.go.service;

import org.springframework.stereotype.Service;

import com.go.repositories.GoLearnAlunoRepository;

@Service
public class GoLearnAlunoService {
    public final GoLearnAlunoRepository goLearnAlunoRepository;

    public GoLearnAlunoService(GoLearnAlunoRepository goLearnAlunoRepository){
        this.goLearnAlunoRepository = goLearnAlunoRepository;
    }
}
