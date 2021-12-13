package edu.cs.uga.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.OrderItem;
import edu.cs.uga.project.repository.OrderItemRepository;

@Service
public class OrderItemService{
	
	private OrderItemRepository orderItemRepo;
	BookService bookService;

	public OrderItemService(OrderItemRepository orderItemRepository) {
		super();
		this.orderItemRepo = orderItemRepository;
	}
	
	public List<OrderItem> findByOrderID(Long orderID) {
		return orderItemRepo.findAllByOrderID(orderID);
	}
	
}
