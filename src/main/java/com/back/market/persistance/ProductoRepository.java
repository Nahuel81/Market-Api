/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.market.persistance;

import com.back.market.domain.Product;
import com.back.market.domain.repository.ProductRepository;
import com.back.market.persistance.crud.ProductoCrudRepository;
import com.back.market.persistance.entity.Producto;
import com.back.market.persistance.mapper.ProductMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository{
 
    @Autowired
    private ProductoCrudRepository productoRepository;
    @Autowired
    private ProductMapper mapper;
    
    
    @Override
    public List<Product> getAll() {
       List<Producto>productos = (List<Producto>) productoRepository.findAll();
     return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int CategoryId) {
      List<Producto>productos= productoRepository.findByIdCategoriaOrderByNombreProductoAsc(CategoryId);
      return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
       Optional<List<Producto>>productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(producto->
                mapper.toProducts(producto));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoRepository.findById(productId).map(producto->
                mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
       Producto producto = mapper.toProducto(product);
       return mapper.toProduct(productoRepository.save(producto));
    }

    @Override
    public void delete(int productid) {
        productoRepository.deleteById(productid);
    }
}
