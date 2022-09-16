package com.pratik.productservice.model;

import java.util.List;

public class OrderModel {

	private Long userId;

	private String orderNumber;

	private List<OrderDetailsmodel> orderDetailsModels;

	public OrderModel() {
		super();
	}

	public OrderModel(Long userId, String orderNumber, List<OrderDetailsmodel> orderDetailsModels) {
		super();
		this.userId = userId;
		this.orderNumber = orderNumber;
		this.orderDetailsModels = orderDetailsModels;
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

	public List<OrderDetailsmodel> getOrderDetailsModels() {
		return orderDetailsModels;
	}

	public void setOrderDetailsModels(List<OrderDetailsmodel> orderDetailsModels) {
		this.orderDetailsModels = orderDetailsModels;
	}

}
