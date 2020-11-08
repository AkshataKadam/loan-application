package com.example.demo.service;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	public List<Loan> listAll() {
		return loanRepository.findAll();
	}

	public Loan saveLoan(Loan product) {
		return loanRepository.save(product);
	}

	public Loan get(Long id) {
		return loanRepository.findById(id).get();
	}

	public void delete(Long id) {
		loanRepository.deleteById(id);
	}

	private static List<Loan> loans = new ArrayList();

	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}

	public Loan deleteById(long id) {
		Loan loan = findById(id);

		if (loan == null)
			return null;

		if (loans.remove(loan)) {
			return loan;
		}
		return null;
	}

	public Loan findById(long id) {
		for (Loan loan : loans) {
			if (loan.getId() == id)
				return loan;
		}
		return null;
	}

	// --------------------schedule
	

}
