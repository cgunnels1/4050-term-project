package edu.cs.uga.project.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import edu.cs.uga.project.web.dto.PromotionDto;


import java.util.Random;

@Entity
@Table(name = "promotions", uniqueConstraints = @UniqueConstraint(columnNames = "promotionID"))
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "promotionID")
	private Long promotionID;

	String promotionCode;

	private double percentage;

	private String startTime;

	private String endTime;

	public Promotion() {

	}

	/**
	 * @param percentage
	 * @param startTime
	 * @param endTime
	 */
	public Promotion(double percentage, String startTime, String endTime) {
		super();
		this.percentage = percentage;
		this.promotionCode = this.generateCode();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public Promotion(PromotionDto promoDto){
		this.percentage = promoDto.getPercentage();
		this.promotionCode = this.generateCode();
		this.startTime = promoDto.getStartTime();
		this.endTime = promoDto.getEndTime();
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Long getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(Long promotionID) {
		this.promotionID = promotionID;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	private String generateCode() {
		char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };

		Random random = new Random();

		char[] code = new char[10];
		for (int i = 0; i < 10; i++) {
			code[i] = CHARS[random.nextInt(CHARS.length)];
		}
		return String.valueOf(code);
	}
}
