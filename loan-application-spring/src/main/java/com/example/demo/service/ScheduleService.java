package com.example.demo.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.response.LoanSchedule;
import com.example.demo.entity.Loan;
import com.example.demo.entity.Schedule;
import com.example.demo.jpa.repository.LoanRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private LoanRepository loanRepository;

	Calendar calendar = Calendar.getInstance();

	public LoanSchedule calculateSchedule(Long loanId) {
		Optional<Loan> findById = loanRepository.findById(loanId);
		if (findById.isPresent()) {
			System.out.println("calculate schedule " + loanId);
			LoanSchedule loanSchedule = new LoanSchedule();
			Loan loan = findById.get();
			loanSchedule.setLoanId(loan.getId());
			loanSchedule.setLoanStartDate(loan.getLoanStartDate());
			loanSchedule.setPrincipal(loan.getLoanAmount());
			loanSchedule.setInterest(loan.getInterestRate());
			loanSchedule.setSchedule(paySchedule(loan));
			return loanSchedule;
		}

		return null;
	}

	public List<Schedule> paySchedule(Loan loan) {
		List<Schedule> listSchedule = new ArrayList<Schedule>();
		int installments = 0;
		int interest = 0;
		int principal = 0;
		int pay = 0;
		int x = loan.getLoanAmount();
		Date date = loan.getLoanStartDate();

		if (loan.getPaymentFrequency().equals("Monthly")) {
			installments = 12;
			System.out.println(loan.getPaymentFrequency());
		} else if (loan.getPaymentFrequency().equals("Quarterly")) {
			installments = 4;
			System.out.println(loan.getPaymentFrequency());
		} else if (loan.getPaymentFrequency().equals("Half-Yearly")) {
			installments = 2;
			System.out.println(loan.getPaymentFrequency());
		} else if (loan.getPaymentFrequency().equals("Yearly")) {
			installments = 1;
			System.out.println(loan.getPaymentFrequency());
		}

		else {
			installments = 4;
		}

		if (loan.getPaymentTerm().equals("Projected Interest")) {
			principal = x / installments;

			while (x > 1) {
				interest = (int) ((loan.getInterestRate() * 0.01 / installments) * x);
				pay = principal + interest;
				Schedule dispSchedule = new Schedule();
				dispSchedule.setPrincipal(principal);
				dispSchedule.setPaymentDate(date);
				if (date.compareTo(new Date()) > 0) {
					dispSchedule.setPaymentStatus("Projected");
				}

				else {
					dispSchedule.setPaymentStatus("Paid");
				}

				date = dateManipulation(date);

				dispSchedule.setProjectedInterest(interest);
				dispSchedule.setPaymentAmount(pay);
				listSchedule.add(dispSchedule);
				x = x - principal;
			}
		} else if (loan.getPaymentTerm().equals("Interest Only")) {
			principal = 0;
			interest = (int) ((loan.getInterestRate() * 0.01 / installments) * x);
			while (installments > 0) {

				Schedule dispSchedule = new Schedule();
				dispSchedule.setPrincipal(principal);
				dispSchedule.setPaymentDate(date);
				if (date.compareTo(new Date()) > 0) {
					dispSchedule.setPaymentStatus("Projected");
				}

				else {
					dispSchedule.setPaymentStatus("Paid");
				}

				date = dateManipulation(date);
				dispSchedule.setProjectedInterest(interest);
				dispSchedule.setPaymentAmount(interest);
				listSchedule.add(dispSchedule);
				installments--;
			}
		}

		return listSchedule;

	}

	// Date Manipulation
	public Date dateManipulation(Date date1) {
		System.out.println("Dateeeee" + date1);
		Date date = date1;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		formatter = new SimpleDateFormat("dd MMMM yyyy");
		strDate = formatter.format(date);
		System.out.println("Date Format with dd MMMM yyyy : " + strDate);

		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(strDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.MONTH, 1); // number of days to add
		strDate = formatter.format(c.getTime());
		System.out.println("Final date : " + strDate);

		DateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
		Date newDate;
		try {
			newDate = format.parse(strDate);
			return newDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
