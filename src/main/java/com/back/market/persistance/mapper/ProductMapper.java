/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.market.persistance.mapper;

import com.back.market.domain.Product;
import com.back.market.persistance.entity.Producto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
        @Mapping(source="id", target="productId"),
        @Mapping(source="nombreProducto", target="name"),
        @Mapping(source="idCategoria", target="categoryId"),
        @Mapping(source="precioVenta", target="price"),
        @Mapping(source="cantidadStock", target="stock"),
        @Mapping(source="estado", target="active"),
        @Mapping(source="categoria", target="category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);
    
    @InheritInverseConfiguration
    @Mapping(target="codigoBarra",ignore= true)
    Producto toProducto(Product product);
    
}
