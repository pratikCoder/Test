package com.pratik.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.productservice.entity.Order;
import com.pratik.productservice.entity.Product;
import com.pratik.productservice.model.OrderModel;
import com.pratik.productservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/order/{userId}")
	public ResponseEntity getOrderByUserId(@PathVariable Long userId) {
		List<Order> orderList = orderService.getOrderByUserId(userId);
		return ResponseEntity.ok(orderList);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/order")
	public ResponseEntity saveOrder(@RequestBody OrderModel order) throws Exception {
		@SuppressWarnings("unused")
		boolean isSaved = orderService.saveOrder(order);
		return ResponseEntity.ok("Ordered Successfully!!!");
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/product/{productId}")
	public ResponseEntity getProductById(@PathVariable Long productId) {
		Product product = orderService.getProductById(productId);
		return ResponseEntity.ok(product);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/product")
	public ResponseEntity saveProduct(@RequestBody Product product) throws Exception {
		@SuppressWarnings("unused")
		boolean isSaved = orderService.saveProduct(product);
		return ResponseEntity.ok("Product Saved Successfully!!!");
	}
}
