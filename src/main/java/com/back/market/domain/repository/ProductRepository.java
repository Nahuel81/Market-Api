/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.back.market.domain.repository;

import com.back.market.domain.Product;
import java.util.List;
import java.util.Optional;


public interface ProductRepository {
   List<Product>getAll();
   Optional<List<Product>>getByCategory(int CategoryId);
   Optional<List<Product>>getScarseProducts(int cantidad);
   Optional<Product>getProduct(int productId);
   Product save(Product product);
   void delete(int productid);
}
