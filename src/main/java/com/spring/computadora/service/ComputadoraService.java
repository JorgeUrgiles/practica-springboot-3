package com.spring.computadora.service;

import com.spring.computadora.entities.Computadora;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ComputadoraService {
    List<Computadora> obtenerTodas();

    Computadora obtenerPorId(Long id);

    Computadora crearComputadora(Computadora computadora);

    Computadora actualizarComputadora(Long id, Computadora computadora);

    void eliminarComputadora(Long id);



}
