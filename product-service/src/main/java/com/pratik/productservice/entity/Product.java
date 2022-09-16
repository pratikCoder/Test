package com.pratik.productservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
//@NamedQuery(name = "Product.findAll", query = "SELECT p FROM PRODUCT p")
public class Product implements Serializable {
	private static final long serialVersionUID = 5285805010576625530L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	private String productName;

	private Long qty;

	public Product() {
		super();
	}

	public Product(Long productId, String productName, Long qty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.qty = qty;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
}
