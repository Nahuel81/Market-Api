
package com.back.market.persistance.crud;

import com.back.market.persistance.entity.Compra;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface ComprasCrudRepository extends CrudRepository<Compra , Integer>{
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
