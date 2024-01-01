package com.example.nasastealphoto.service;

import com.example.nasastealphoto.model.Sol;
import com.example.nasastealphoto.repository.SolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SolService {
    private final SolRepository solRepository;

    public Optional<Sol> getSolByData(String data) {
        return solRepository.findByData(data);
    }

    @Transactional
    public void saveSol(String data) {
        Sol sol = createSol(data);
        solRepository.save(sol);
    }

    private Sol createSol(String data) {
        Sol sol = new Sol();
        sol.setData(data);
        return sol;
    }
}
