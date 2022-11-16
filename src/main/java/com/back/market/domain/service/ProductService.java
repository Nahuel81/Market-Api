
package com.back.market.domain.service;

import com.back.market.domain.Product;
import com.back.market.domain.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productRepository; 
    
    public List<Product>getAll(){
    return productRepository.getAll();
    }
    
    public Optional<List<Product>> getByCategory(int id){
    return productRepository.getByCategory(id);
    }
    
    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }
    
    public Product Save(Product producto){
    return productRepository.save(producto);
    }
    
    public boolean delete(int id){
    return getProduct(id).map(producto->{
    productRepository.delete(id);
    return true;
    }).orElse(false);
    }
            
}
