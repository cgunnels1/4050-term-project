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
@Table(name =  "orderItems", uniqueConstraints = @UniqueConstraint(columnNames = "itemID"))
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemID;
	
	@Column(name = "orderID")
	private Long orderID;
	
	@Column(nullable = false)
	private Long bookID;

	@Column(nullable = false)
	private int quantity;

	/**
	 * @param orderID
	 * @param bookID
	 * @param quantity
	 */
	public OrderItem(Long orderID, Long bookID, int quantity) {
		super();
		this.orderID = orderID;
		this.bookID = bookID;
		this.quantity = quantity;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
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

	public Long getItemID() {
		return itemID;
	}
	
	
	
}

	
	
	
