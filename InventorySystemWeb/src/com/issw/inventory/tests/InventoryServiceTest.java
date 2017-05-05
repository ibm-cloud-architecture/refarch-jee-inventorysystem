package com.issw.inventory.tests;

import javax.naming.InitialContext;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

import com.issw.inventory.data.Product;
import com.issw.inventory.exceptions.NoSuchProductException;
import com.issw.inventory.service.InventoryService;


public class InventoryServiceTest extends DBTestCase {

	
	private InventoryService inventoryService;
	
	public InventoryServiceTest(String name) {
		super(name);
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.ibm.db2.jcc.DB2Driver" );
	    System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:db2://localhost:60000/INDB" );
	    System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "DB2INST1" );
	    System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "db2inst1" );
	    System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "was1edu2" );
	}
	
	public void setUp() throws Exception {
		
		super.setUp();
		
		InitialContext ctx = new InitialContext();
		inventoryService = (InventoryService)ctx.lookup("ejblocal:com.issw.inventory.service.InventoryService");
		
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		ReplacementDataSet dataSet = new ReplacementDataSet(
		        new FlatXmlDataSet(this.getClass().getResourceAsStream ("InventoryInitialDataSet.xml"))); 
		dataSet.addReplacementObject("[null]", null);
		return dataSet;
	}
	
	protected DatabaseOperation getSetUpOperation() 
	  throws Exception {
	    return DatabaseOperation.CLEAN_INSERT;
	 }
	
	protected DatabaseOperation getTearDownOperation() 
	  throws Exception {
		return DatabaseOperation.NONE;
	}
	
	public void testAccessProduct()
	{
		int sku = 1;
		Product product;
		try {
			product = inventoryService.accessProduct(sku);
		} catch (NoSuchProductException e) {
			// TODO Auto-generated catch block
			fail("NoSuchProductException");
			return;
		}
		
		assertEquals(sku, product.getSku());
		assertEquals(20, product.getStock());
		assertEquals(1, product.getVersion());
		assertEquals(1, product.getSupplierId());
	}
	
	public void testUpdateProduct()
	{
		int sku = 1;
		Product product;
		try {
			product = inventoryService.accessProduct(sku);
			int inStock = product.getStock();
			int oldVersionNum = product.getVersion();
			product.setStock(inStock - 1);
			inventoryService.updateProduct(product);
			product = inventoryService.accessProduct(sku);
			assertEquals(sku,product.getSku());
			assertEquals(inStock-1, product.getStock());
			assertEquals(oldVersionNum + 1, product.getVersion());
			
		} catch (NoSuchProductException e) {
			// TODO Auto-generated catch block
			fail("NoSuchProductException");
			return;
		}
	}
	
	public void testInsertProduct()
	{
		try {
			Product newProduct = new Product();
			newProduct.setSku(2222);
			newProduct.setSupplierId(1);
			newProduct.setStock(20);
			inventoryService.insertProduct(newProduct);
			Product product = inventoryService.accessProduct(newProduct.getSku());
			assertEquals(product.getSku(),newProduct.getSku());
			assertEquals(product.getStock(),newProduct.getStock());
			assertEquals(product.getSupplierId(),newProduct.getSupplierId());
			assertEquals(product.getVersion(),1);
			inventoryService.removeProduct(product);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getLocalizedMessage());
			return;
		}
		
	}
	
	public void testRemoveProduct()
	{
		try {
			Product newProduct = new Product();
			newProduct.setSku(2222);
			newProduct.setSupplierId(1);
			newProduct.setStock(20);
			inventoryService.insertProduct(newProduct);
			Product product = inventoryService.accessProduct(newProduct.getSku());
			inventoryService.removeProduct(product);
			try
			{
				product = inventoryService.accessProduct(newProduct.getSku());
				if(product == null) assertTrue(true);
			}
			catch (Exception e) {
				// Correct Exception
				assertTrue(true);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getLocalizedMessage());
			return;
		}
	}

}