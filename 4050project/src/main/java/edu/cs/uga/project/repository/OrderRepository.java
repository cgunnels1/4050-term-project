package edu.cs.uga.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.CardInformation;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
