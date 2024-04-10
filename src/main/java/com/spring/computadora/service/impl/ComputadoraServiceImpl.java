package com.spring.computadora.service.impl;

import com.spring.computadora.entities.Computadora;
import com.spring.computadora.repository.ComputadoraRepository;
import com.spring.computadora.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputadoraServiceImpl implements ComputadoraService {

    @Autowired
    private ComputadoraRepository computadoraRepository;

    @Override
    public List<Computadora> obtenerTodas() {
        return computadoraRepository.findAll();
    }

    @Override
    public Computadora obtenerPorId(Long id) {
        return computadoraRepository.findById(id).orElse(null);
    }

    @Override
    public Computadora crearComputadora(Computadora computadora) {
        return computadoraRepository.save(computadora);
    }

    @Override
    public Computadora actualizarComputadora(Long id, Computadora computadora) {
        Computadora computadoradb = computadoraRepository.findById(id).orElse(null);
        if(computadoradb != null){
            computadoradb.setMarca(computadora.getMarca());
            computadoradb.setModelo(computadora.getModelo());
            computadoradb.setProcesadorMarca(computadora.getProcesadorMarca());
            computadoradb.setProcesadorVelocidad(computadora.getProcesadorVelocidad());
            computadoradb.setProcesadorGeneracion(computadora.getProcesadorGeneracion());
            computadoradb.setRamTipo(computadora.getRamTipo());
            computadoradb.setRamCapacidad(computadora.getRamCapacidad());
            computadoradb.setDiscoDuroTipo(computadora.getDiscoDuroTipo());
            computadoradb.setDiscoDuroCapacidad(computadora.getDiscoDuroCapacidad());
            computadoradb.setGraficaMarca(computadora.getGraficaMarca());
            computadoradb.setGraficaCapacidad(computadora.getGraficaCapacidad());
            return computadoraRepository.save(computadoradb);
        }
        return null;
    }

    @Override
    public void eliminarComputadora(Long id) {
         computadoraRepository.deleteById(id);

    }
}
