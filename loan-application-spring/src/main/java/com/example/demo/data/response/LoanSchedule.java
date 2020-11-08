package com.example.demo.data.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Schedule;

public class LoanSchedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8889849735089684967L;
	private Long loanId;
	private Date loanStartDate;
	private int principal;
	private int interest;
	private List<Schedule> schedule;
	
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public List<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
}
