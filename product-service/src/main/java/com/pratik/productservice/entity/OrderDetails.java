package com.pratik.productservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERDETAILS")
//@NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM ORDERDETAILS o")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = -1153342436444628641L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDetailsId;

	private Long orderId;

	private Long productId;

	private Long qty;

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long orderDetailsId, Long orderId, Long productId, Long qty) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.orderId = orderId;
		this.productId = productId;
		this.qty = qty;
	}

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
