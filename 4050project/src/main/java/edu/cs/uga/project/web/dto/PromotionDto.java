package edu.cs.uga.project.web.dto;

import java.sql.Timestamp;


public class PromotionDto {
	private long promotionID;

	String promotionCode;

	private double percentage;

	private String startTime;

	private String endTime;

	public PromotionDto() {

	}

	/**
	 * @param promotionCode
	 * @param percentage
	 * @param startTime
	 * @param endTime
	 */
	public PromotionDto(String promotionCode, double percentage, String startTime, String endTime) {
		super();
		this.promotionCode = promotionCode;
		this.percentage = percentage;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(long promotionID) {
		this.promotionID = promotionID;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
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

	

}
