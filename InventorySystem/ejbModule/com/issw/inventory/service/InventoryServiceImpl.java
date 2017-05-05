package com.issw.inventory.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import com.ibm.pdq.runtime.Data;
import com.ibm.pdq.runtime.factory.DataFactory;
import com.issw.inventory.data.Product;
import com.issw.inventory.exceptions.NoSuchProductException;
import com.issw.inventory.exceptions.ProductNotCreatedException;

@Stateless
public class InventoryServiceImpl implements InventoryService {
	@Resource(name="jdbc/indsRef")
	private DataSource ds;
    
    public Product accessProduct(int sku) throws NoSuchProductException {
		Data data = DataFactory.getData(ds);
		Product product =  data.queryFirst ("select SKU, INSTOCK, VERSION, SUPP_ID from PRODUCT where SKU = ?", Product.class,sku);
		return product;
	}

	public void updateProduct(Product product) throws NoSuchProductException {
		Data data = DataFactory.getData(ds);
		int result = data.update("update PRODUCT set SKU = :sku, INSTOCK = :stock, VERSION = :version + 1, SUPP_ID = :supplierId where SKU = :sku and VERSION = :version", product);
		if(result <= 0) throw new NoSuchProductException();
	}
	
	public int insertProduct(Product product)throws ProductNotCreatedException
	{
		Data data = DataFactory.getData(ds);
		int result = data.update("insert into PRODUCT (SKU, INSTOCK, VERSION, SUPP_ID) values( :sku, :stock, 1, :supplierId)", product);
		if(result <= 0) throw new ProductNotCreatedException();
		return product.getSku();
	}
	
	public void removeProduct(Product product) throws NoSuchProductException 
	{
		Data data = DataFactory.getData(ds);
		int result = data.update("DELETE FROM PRODUCT where SKU = :sku and VERSION = :version", product);
		if(result <= 0) throw new NoSuchProductException("Or version is wrong");
	}
    
    

}
