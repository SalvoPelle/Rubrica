package com.example.Rubrica.repository;

import com.example.Rubrica.models.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepo extends JpaRepository<Contatto, Long> {
}
