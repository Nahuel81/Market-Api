
package com.back.market.domain.repository;

import com.back.market.domain.Purchase;
import java.util.List;
import java.util.Optional;


public interface PurchaseRepository {
    
    List<Purchase>getAll(); //optional
    Optional<List<Purchase>>getByClient(String ClientId);
    Purchase save(Purchase purchase);
    
}
