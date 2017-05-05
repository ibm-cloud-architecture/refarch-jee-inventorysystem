package com.issw.inventory.data;

/**************************************************************
 *A bean that represents the PRODUCT table.
 * 
 **************************************************************/
// Imports
import com.ibm.pdq.annotation.Id;
import com.ibm.pdq.annotation.Column;

public class Product {

	// Class variables
	protected int sku;
	protected int stock;
	protected int version;
	protected int supplierId;

	/**
	 * Constructor for Product.
	 */
	public Product() {
		super();
	}

	/**
	 * Constructor for Product that sets all fields.
	 */
	public Product(int sku, int stock, int version, int supplierId) {
		super();
		this.sku = sku;
		this.stock = stock;
		this.version = version;
		this.supplierId = supplierId;
	}

	/**
	 * Get sku.
	 * 
	 * @return return sku
	 */
	@Id
	public int getSku() {
		return sku;
	}

	/**
	 * Set sku.
	 * 
	 * @param int sku
	 */
	@Id
	public void setSku(int sku) {
		this.sku = sku;
	}

	/**
	 * Get stock.
	 * 
	 * @return return stock
	 */
	@Column(name = "INSTOCK")
	public int getStock() {
		return stock;
	}

	/**
	 * Set stock.
	 * 
	 * @param int stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Get version.
	 * 
	 * @return return version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Set version.
	 * 
	 * @param int version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Get supplierId.
	 * 
	 * @return return supplierId
	 */
	@Column(name = "SUPP_ID")
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * Set supplierId.
	 * 
	 * @param int supplierId
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}