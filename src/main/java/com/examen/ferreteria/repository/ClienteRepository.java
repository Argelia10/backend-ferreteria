package com.examen.ferreteria.repository;

import com.examen.ferreteria.entity.Cliente;
import com.examen.ferreteria.dto.ClienteFacturaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Endpoint 3: Facturas por cliente
    @Query(value = "SELECT c.NOMBRE as nombre, c.APELLIDO as apellido, c.NIT as nit, f.FECHA_FACTURA as fechaFactura, f.TOTAL as total " +
                   "FROM factura f JOIN cliente c ON f.ID_CLIENTE = c.ID_CLIENTE " +
                   "WHERE f.ESTADO_FACTURA = 1 AND c.ESTADO = 1 ORDER BY f.FECHA_FACTURA DESC", nativeQuery = true)
    List<ClienteFacturaDto> obtenerReporteClienteFactura();
}