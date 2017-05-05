package com.issw.inventory.service;
import javax.ejb.Local;

import com.issw.inventory.data.Product;
import com.issw.inventory.exceptions.NoSuchProductException;
import com.issw.inventory.exceptions.ProductNotCreatedException;

@Local
public interface InventoryService {
	
	public Product accessProduct(int sku) throws NoSuchProductException;
	public void updateProduct(Product product)throws NoSuchProductException;
	public int insertProduct(Product product) throws ProductNotCreatedException;
	public void removeProduct(Product product) throws NoSuchProductException ;

}


