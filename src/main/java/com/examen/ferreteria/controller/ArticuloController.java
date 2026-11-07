package com.examen.ferreteria.controller;

import com.examen.ferreteria.entity.Articulo;
import com.examen.ferreteria.dto.ArticuloCategoriaDto;
import com.examen.ferreteria.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping("/articulos/mostrarActivosFiltroNombre")
    public List<Articulo> mostrarActivosFiltroNombre(@RequestParam(defaultValue = "") String nombre) {
        return articuloRepository.buscarPorNombreFiltro(nombre);
    }

    @GetMapping("/articulos/reporteArticuloCategoria")
    public List<ArticuloCategoriaDto> reporteArticuloCategoria() {
        return articuloRepository.obtenerReporteArticuloCategoria();
    }
}