package edu.cs.uga.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	List<OrderItem> findAllByOrderID(Long orderID);
}
