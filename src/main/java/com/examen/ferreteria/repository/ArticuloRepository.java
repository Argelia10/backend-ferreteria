package com.examen.ferreteria.repository;

import com.examen.ferreteria.entity.Articulo;
import com.examen.ferreteria.dto.ArticuloCategoriaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {

    // Endpoint 1: Filtro por nombre
    @Query(value = "SELECT * FROM articulo WHERE ESTADO = 1 AND LOWER(NOMBRE) LIKE LOWER(CONCAT('%', :nombre, '%'))", nativeQuery = true)
    List<Articulo> buscarPorNombreFiltro(@Param("nombre") String nombre);

    // Endpoint 2: Artículos con su categoría
    @Query(value = "SELECT a.NOMBRE as nombreArticulo, a.MARCA as marca, c.NOMBRE as nombreCategoria, a.PRECIO as precio, a.STOCK as stock " +
                   "FROM articulo a JOIN categoria c ON a.ID_CATEGORIA = c.ID_CATEGORIA " +
                   "WHERE a.ESTADO = 1 ORDER BY c.NOMBRE ASC, a.NOMBRE ASC", nativeQuery = true)
    List<ArticuloCategoriaDto> obtenerReporteArticuloCategoria();
}