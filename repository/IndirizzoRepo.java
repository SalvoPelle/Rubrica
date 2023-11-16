package com.example.Rubrica.repository;

import com.example.Rubrica.models.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepo extends JpaRepository<Indirizzo, Long> {
}
