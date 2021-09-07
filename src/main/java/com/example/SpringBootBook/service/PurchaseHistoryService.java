package com.example.SpringBootBook.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootBook.model.PurchaseHistory;
import com.example.SpringBootBook.repository.IPurchaseHistoryRepository;
import com.example.SpringBootBook.repository.projection.IPurchaseItem;
import com.example.SpringBootBook.service.Impl.IPurchaseHistoryService;




@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {
	
	
	  private  IPurchaseHistoryRepository purchaseHistoryRepository;

	    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository)
	    {
	        this.purchaseHistoryRepository = purchaseHistoryRepository;
	    }
   

	    @Override
	    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
	    {
	        purchaseHistory.setPurchaseTime(LocalDateTime.now());

	        return purchaseHistoryRepository.save(purchaseHistory);
	    }

	    @Override
	    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId)
	    {
	        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
	    }
	}
