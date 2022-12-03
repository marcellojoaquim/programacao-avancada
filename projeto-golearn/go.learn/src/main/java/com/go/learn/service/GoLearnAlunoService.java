package com.go.learn.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.repository.GoLearnAlunoRepository;

@Service
public class GoLearnAlunoService {

    final GoLearnAlunoRepository goLearnAlunoRepository;

    private PasswordEncoder passwordEncoder;

    public GoLearnAlunoService(GoLearnAlunoRepository goLearnAlunoRepository) {
        this.goLearnAlunoRepository = goLearnAlunoRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<GoLearnAlunoModel> findAll() {
        return goLearnAlunoRepository.findAll();
    }

    @Transactional
    public GoLearnAlunoModel save(GoLearnAlunoModel goLearnAlunoModel) {
        String enconder = this.passwordEncoder.encode(goLearnAlunoModel.getSenha());
        goLearnAlunoModel.setSenha(enconder);
        return goLearnAlunoRepository.save(goLearnAlunoModel);
    }

    public Optional<GoLearnAlunoModel> findById(Long id) {
        return goLearnAlunoRepository.findById(id);
    }

    @Transactional
    public void deletar(GoLearnAlunoModel goLearnAlunoModel) {
        goLearnAlunoRepository.delete(goLearnAlunoModel);
    }

    public boolean existsByCpf(String cpf) {
        return goLearnAlunoRepository.existsByCpf(cpf);
    }

    public boolean validarSenha(GoLearnAlunoModel goLearnAlunoModel) {
        String senha = goLearnAlunoRepository.getReferenceById(goLearnAlunoModel.getIdaluno()).getSenha();
        boolean valid = passwordEncoder.matches(goLearnAlunoModel.getSenha(), senha);
        return valid;
    }
}
