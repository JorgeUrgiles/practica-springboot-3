package com.spring.computadora.repository;

import com.spring.computadora.entities.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Long> {
}
