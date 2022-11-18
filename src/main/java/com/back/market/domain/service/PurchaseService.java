/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.market.domain.service;

import com.back.market.domain.Purchase;
import com.back.market.domain.repository.PurchaseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
   @Autowired
   PurchaseRepository purchaseRepository;
   
   public List<Purchase> getALL(){ //optional
   return purchaseRepository.getAll();
   }
   
  public Optional<List<Purchase>>getByClient(String ClientId){
  return purchaseRepository.getByClient(ClientId);
  }
  
  public Purchase save(Purchase purchase){
  return purchaseRepository.save(purchase);
  }
}
