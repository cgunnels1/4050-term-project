package edu.cs.uga.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import edu.cs.uga.project.util.Priviledge;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name =  "users", uniqueConstraints = @UniqueConstraint(columnNames = "userID"))
public class User {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	@Column(name = "userID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	
	private String email;
	
	private Priviledge priviledge;

	/**
	 * @param userID
	 * @param priviledge
	 */
	public User(String email, Priviledge priviledge) {
		super();
		this.priviledge = priviledge;
		this.email = email;
	}


	public User() {
		
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public Priviledge getPriviledge() {
		return priviledge;
	}


	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}
	
	
	
	
}
