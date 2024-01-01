package com.example.nasastealphoto.repository;

import com.example.nasastealphoto.model.Sol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SolRepository extends JpaRepository<Sol, Long> {
    Optional<Sol> findByData(String data);
}

