package com.go.learn.service;
import com.go.learn.model.FeriadoModel;
import com.go.learn.repository.FeriadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FeriadoService {

    public final FeriadoRepository goLearnFeriadoRepository;

    public FeriadoService(FeriadoRepository goLearnFeriadoRepository) {
        this.goLearnFeriadoRepository = goLearnFeriadoRepository;
    }


    public Optional<FeriadoModel> findById(Long id) {

        return goLearnFeriadoRepository.findById(id);
    }

    @Transactional
    public Object save(FeriadoModel goLearnFeriadoModel) {

        return goLearnFeriadoRepository.save(goLearnFeriadoModel);
    }
    @Transactional
    public void deletar(FeriadoModel goLearnFeriadoModel) {
        goLearnFeriadoRepository.delete(goLearnFeriadoModel);
    }

    public List<FeriadoModel> findAll() {
        return goLearnFeriadoRepository.findAll();

    }

}
