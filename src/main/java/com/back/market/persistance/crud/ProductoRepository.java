package com.back.market.persistance.crud;

import com.back.market.persistance.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {
 
    @Autowired
private ProductoCrudRepository productoRepository;

public List<Producto>traerProductos(){
return (List<Producto>) productoRepository.findAll();
}
    public List<Producto>traerCategorias(int id){
    return productoRepository.findByIdCategoriaOrderByAsc(id);
    }
    
    public Optional<List<Producto>>traerEscasos(int cantidad){
    return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    
    public Optional<Producto>traerProducto(int id){
    return productoRepository.findById(id);
    }
    
    public Producto crearProducto(Producto producto){
     return productoRepository.save(producto);
    }
    
    public void eliminarProducto(int id){
    productoRepository.deleteById(id);
    }
}
