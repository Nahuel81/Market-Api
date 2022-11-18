
package com.back.market.persistance;

import com.back.market.domain.Purchase;
import com.back.market.domain.repository.PurchaseRepository;
import com.back.market.persistance.crud.ComprasCrudRepository;
import com.back.market.persistance.entity.Compra;
import com.back.market.persistance.mapper.PurchaseMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComprasRepository implements PurchaseRepository {

  @Autowired
  ComprasCrudRepository comprasRepository;
  @Autowired
  private PurchaseMapper mapper;
    
    @Override
    public List<Purchase> getAll() {
       return mapper.toPurchases((List<Compra>)
               comprasRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String ClientId){
      return comprasRepository.findByIdCliente(ClientId)
              .map(compras->
              mapper.toPurchases(compras));
      }
             

    @Override
    public Purchase save(Purchase purchase) {
       Compra compra = mapper.toCompra(purchase);
       compra.getProductos().forEach(producto-> producto.setCompra(compra));
       
       return mapper.toPurchase(comprasRepository.save(compra));
    }
    
}
