package edu.cs.uga.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cs.uga.project.model.AddressInformation;
import edu.cs.uga.project.model.Customer;

@Repository
public interface AddressInformationRepository extends JpaRepository<AddressInformation, Long>{
}
