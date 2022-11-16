/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.back.market.persistance.crud;

import com.back.market.persistance.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    
    List<Producto> findByIdCategoriaOrderByNombreProductoAsc(int idCategoria);
    Optional<List<Producto>>findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
