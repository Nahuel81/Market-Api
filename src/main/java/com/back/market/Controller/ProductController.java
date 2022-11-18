package com.back.market.Controller;

import com.back.market.domain.Product;
import com.back.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
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
    @ApiOperation("Obtener todos los productos del mercado")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar un producto por un ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Producto no encontrado"),})
    public ResponseEntity<Product> getProduct(@ApiParam(value = "Inserte ID del Producto", required = true, example = "6")
            @PathVariable("id") int id) {
        return productService.getProduct(id).map(producto->
                new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Obtener todos los Productos de una sola Categoria por ID. (ejemplo: id:1 = categoria: Frutas y Verduras ")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int id) {
        return productService.getByCategory(id).map(productos
                -> new ResponseEntity<>(productos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    @ApiOperation("Agregar un nuevo Producto")
    public ResponseEntity<Product> Save(@RequestBody Product producto) {
        return new ResponseEntity<>(productService.Save(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Borrar un producto por ID")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (productService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
