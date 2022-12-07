package com.go.learn.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.go.learn.model.AlunoModel;
import com.go.learn.repository.AlunoRepository;

@Service
public class AlunoService {

    final AlunoRepository alunoRepository;

    private PasswordEncoder passwordEncoder;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<AlunoModel> findAll() {
        return alunoRepository.findAll();
    }

    @Transactional
    public AlunoModel save(AlunoModel alunoModel) {
        String enconder = this.passwordEncoder.encode(alunoModel.getSenha());
         alunoModel.setSenha(enconder);
        return alunoRepository.save(alunoModel);
    }

    public Optional<AlunoModel> findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public void deletar(AlunoModel alunoModel) {
        alunoRepository.delete(alunoModel);
    }

    public boolean existsByCpf(String cpf) {
        return alunoRepository.existsByCpf(cpf);
    }

    public boolean validarSenha(AlunoModel alunoModel) {
        String senha = alunoRepository.getReferenceById(alunoModel.getIdaluno()).getSenha();
        boolean valid = passwordEncoder.matches(alunoModel.getSenha(), senha);
        return valid;
    }

    public List<String>findNomeByTurmas(Long turmas){
        return alunoRepository.findNomeByTurma(turmas);
    }
}
