package com.pratik.productservice.model;

public class OrderDetailsmodel {

	private Long productId;

	private Long qty;

	public OrderDetailsmodel() {
		super();
	}

	public OrderDetailsmodel(Long productId, Long qty) {
		super();
		this.productId = productId;
		this.qty = qty;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

}
