
package com.back.market.Controller;

import com.back.market.domain.Purchase;
import com.back.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class PurchaseController {
    
    @Autowired
    private PurchaseService purchaseService;
    
    @GetMapping("/all") //optional
    @ApiOperation("Obtener todas las compras") //orientacion de swagger
    public ResponseEntity<List<Purchase>> getAll(){
    return new ResponseEntity<>(purchaseService.getALL(),HttpStatus.OK);
    }
    
    @GetMapping("/cliente/{idClient}")
    @ApiOperation("Obtener todas las compras de un solo cliente por su ID") //orientacion de swagger
    public ResponseEntity <List<Purchase>> getByClient(@PathVariable("idClient") String clientId){
    return purchaseService.getByClient(clientId)
    .map(purchases-> new ResponseEntity<>(purchases, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    @ApiOperation("Realizar una compra. Nota:(se nececita el ID CLIENTE, puede obtenerlo ejecutando el metodo obtener todas las compras y copiando el ID del cliente. "
            + "el purchaseID debe quedar en cero, se asigna automaticamente)") //orientacion de swagger
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
    
}