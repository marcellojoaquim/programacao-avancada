package com.go.learn.service;

import org.springframework.stereotype.Service;

import com.go.learn.repository.GoLearnAlunoRepository;


@Service
public class GoLearnAlunoService {
    public final GoLearnAlunoRepository goLearnAlunoRepository;

    public GoLearnAlunoService(GoLearnAlunoRepository goLearnAlunoRepository){
        this.goLearnAlunoRepository = goLearnAlunoRepository;
    }
}
