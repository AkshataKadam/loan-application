package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242705904928056387L;
	//private Long id;
	private Date paymentDate;
	private int principal;
	private int projectedInterest;
	private String paymentStatus;
	private int paymentAmount;
	
	

	public Schedule() {
		
	}
	
	public Schedule(Date paymentDate, int principal, int projectedInterest, String paymentStatus, int paymentAmount) {
		super();
		//this.id = id;
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectedInterest = projectedInterest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}
	
	
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public int getProjectedInterest() {
		return projectedInterest;
	}
	public void setProjectedInterest(int projectedInterest) {
		this.projectedInterest = projectedInterest;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}
