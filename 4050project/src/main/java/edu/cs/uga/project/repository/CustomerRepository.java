package edu.cs.uga.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByEmail(String email);
	//Customer findByUserID(Long userID);
	List<Customer> findAll();
}
