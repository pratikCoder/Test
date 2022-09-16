package com.pratik.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.productservice.entity.Order;
import com.pratik.productservice.entity.OrderDetails;
import com.pratik.productservice.entity.Product;
import com.pratik.productservice.model.OrderDetailsmodel;
import com.pratik.productservice.model.OrderModel;
import com.pratik.productservice.repository.OrderDetailsRepository;
import com.pratik.productservice.repository.OrderRepository;
import com.pratik.productservice.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderDetailsRepository orderDetailsRepo;

	@Autowired
	private ProductRepository productRepo;

	public List<Order> getOrderByUserId(Long userId) {
		List<Order> orderlist = orderRepo.findByUserId(userId);

		return orderlist;
	}

	public boolean saveOrder(OrderModel orderModel) throws Exception {
		try {
			Order order = new Order();
			order.setUserId(orderModel.getUserId());
			order.setOrderNumber(orderModel.getOrderNumber());
			order = orderRepo.save(order);

			long orderId = order.getOrderId();

			List<OrderDetailsmodel> orderDetailsModelList = orderModel.getOrderDetailsModels();

			orderDetailsModelList.forEach(obj -> {
				OrderDetails orderDetails = new OrderDetails();
				orderDetails.setOrderId(orderId);
				orderDetails.setProductId(obj.getProductId());

				Product product = productRepo.findByProductId(obj.getProductId());
				if (product.getQty() > obj.getQty()) {
					product.setQty(product.getQty() - obj.getQty());
					orderDetails.setQty(obj.getQty());
				} else if (product.getQty() < obj.getQty()) {
					product.setQty(product.getQty() - product.getQty());
					orderDetails.setQty(product.getQty());
				} else {
					product.setQty(new Long(0));
					orderDetails.setQty(product.getQty());
				}
				productRepo.save(product);
				orderDetailsRepo.save(orderDetails);
			});
			return true;
		} catch (Exception e) {
			throw new Exception("Order Data save failed!!", e);
		}
	}

	public Product getProductById(Long productId) {
		Product product = productRepo.findByProductId(productId);
		return product;
	}

	public boolean saveProduct(Product product) throws Exception {
		try {
			productRepo.save(product);
			return true;
		} catch (Exception e) {
			throw new Exception("Product Not saved!!!", e);
		}
	}
}
