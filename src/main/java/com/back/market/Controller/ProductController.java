
package com.back.market.Controller;

import com.back.market.domain.Product;
import com.back.market.domain.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/all")
     public ResponseEntity<List<Product>>getAll(){
     return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
     }
    
         @GetMapping("/{id}")
     public ResponseEntity<Product>getProduct(@PathVariable("id") int id){
     return productService.getProduct(id).map(producto->
     new ResponseEntity<>(producto, HttpStatus.OK))
             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
     
     
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>>getByCategory(@PathVariable("id") int id){
    return productService.getByCategory(id).map(productos->
    new ResponseEntity<>(productos, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            
    }
  
     
     @PostMapping("/save")
     public ResponseEntity<Product> Save(@RequestBody Product producto){
     return new ResponseEntity<>(productService.Save(producto), HttpStatus.CREATED);
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity delete(@PathVariable("id") int id){
     if(productService.delete(id)){
         return new ResponseEntity(HttpStatus.OK);
     }else{ 
         return new ResponseEntity(HttpStatus.NOT_FOUND);
     }
     }
}
