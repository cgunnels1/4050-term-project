package edu.cs.uga.project.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.ShoppingCartDto;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name =  "shoppingcarts", uniqueConstraints = @UniqueConstraint(columnNames = "shoppingcartID"))
public class ShoppingCart {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoppingCartID")
	private Long shoppingCartID;
	
	@Column(name = "customerID")
	private Long customerID;
	
	@Column(nullable = false)
	private Long bookID;

	@Column(nullable = false)
	private int quantity;

	
	
	
	public ShoppingCart() {
		super();
	}

	/**
	 * @param bookID
	 * @param quantity
	 */
	public ShoppingCart(Long customerID, Long bookID, int quantity) {
		super();
		this.customerID = customerID;
		this.bookID = bookID;
		this.quantity = quantity;
	}

	
	public ShoppingCart(ShoppingCartDto cartDto) {
		super();
		this.customerID = cartDto.getCustomerID();
		this.bookID = cartDto.getBookID();
		this.quantity = cartDto.getQuantity();
	}

	
	
	
	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getShoppingCartID() {
		return shoppingCartID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}	
	
	
	

	
}
