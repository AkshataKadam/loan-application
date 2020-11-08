package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6461872564744742955L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "customerId")
	private int customerId;

	@Column(name = "loanAmount")
	private int loanAmount;

	@Column(name = "paymentFrequency")
	private String paymentFrequency;

	@Column(name = "paymentTerm")
	private String paymentTerm;

	@Column(name = "tradeDate")
	private Date tradeDate;

	@Column(name = "loanStartDate")
	private Date loanStartDate;

	@Column(name = "maturityDate")
	private Date maturityDate;

	@Column(name = "interestRate")
	private int interestRate;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Loan(Long id, int customerId, int loanAmount, String paymentFrequency, String paymentTerm, Date tradeDate,
			Date loanStartDate, Date maturityDate, int interestRate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.paymentFrequency = paymentFrequency;
		this.paymentTerm = paymentTerm;
		this.tradeDate = tradeDate;
		this.loanStartDate = loanStartDate;
		this.maturityDate = maturityDate;
		this.interestRate = interestRate;
	}

	public Date getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	protected Loan() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

}
