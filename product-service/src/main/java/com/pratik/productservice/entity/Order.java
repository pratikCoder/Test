package com.pratik.productservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
//@NamedQuery(name = "Order.findAll", query = "SELECT o FROM ORDER o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1548503891896145999L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	private Long userId;

	private String orderNumber;

	public Order() {
		super();
	}

	public Order(Long orderId, Long userId, String orderNumber) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderNumber = orderNumber;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}
