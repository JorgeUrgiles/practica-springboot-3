package com.spring.computadora.controller;

import com.spring.computadora.entities.Computadora;
import com.spring.computadora.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/computadoras")
public class ComputadoraController {

    @Autowired
    private ComputadoraService computadoraService;

    @GetMapping
    public String listarComputadoras(Model model){
        List<Computadora> computadoras = computadoraService.obtenerTodas();
        model.addAttribute("listaComputadoras", computadoras);
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaComputadora(Model model){
        model.addAttribute("computadora", new Computadora());
        model.addAttribute("accion", "/computadoras/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarNuevaComputadora(@Validated @ModelAttribute("computadora") Computadora computadora, BindingResult result){
        if (result.hasErrors()) {
            return "formulario"; // Vuelve al formulario con errores si la validación falla
        }
        computadoraService.crearComputadora(computadora);
        return "redirect:/computadoras";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarComputadora(@PathVariable Long id, Model model){
        Computadora computadora = computadoraService.obtenerPorId(id);
        model.addAttribute("computadora", computadora);
        model.addAttribute("accion", "/computadoras/editar/" + id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarComputadora(@Validated @PathVariable Long id, @ModelAttribute("computadora") Computadora computadora, BindingResult result){
        if (result.hasErrors()) {
            return "formulario"; // Vuelve al formulario con errores si la validación falla
        }
        computadoraService.actualizarComputadora(id, computadora);
        return "redirect:/computadoras";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarComputadora(@PathVariable Long id){
        computadoraService.eliminarComputadora(id);
        return "redirect:/computadoras";
    }
}
