package com.examen.ferreteria.controller;

import com.examen.ferreteria.dto.ClienteFacturaDto;
import com.examen.ferreteria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/reporteClienteFactura")
    public List<ClienteFacturaDto> reporteClienteFactura() {
        return clienteRepository.obtenerReporteClienteFactura();
    }
}