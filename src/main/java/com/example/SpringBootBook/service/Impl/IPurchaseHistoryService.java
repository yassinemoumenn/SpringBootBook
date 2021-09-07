package com.example.SpringBootBook.service.Impl;

import java.util.List;

import com.example.SpringBootBook.model.PurchaseHistory;
import com.example.SpringBootBook.repository.projection.IPurchaseItem;



public interface IPurchaseHistoryService {
	 PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

	    List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
	    }