package com.example.demo.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.data.response.LoanSchedule;
import com.example.demo.entity.Loan;
import com.example.demo.entity.Schedule;
import com.example.demo.service.LoanService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;

	@GetMapping("/loans")
	public List<Loan> getAllLoans() {

		return loanService.listAll();
	}

	@GetMapping("/loans/{id}")
	public Loan getLoan(@PathVariable long id) {
		return loanService.findById(id);
	}

	@PostMapping("/loans")
	public ResponseEntity<Void> updateLoan(@RequestBody Loan loan) {
		Loan createdloan = loanService.saveLoan(loan);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdloan.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	


	

	/*@PutMapping("/users/{customerId}/loans/{id}")
	public ResponseEntity<Loan> updateloan(@PathVariable int customerId, @PathVariable long id,
			@RequestBody Loan loan) {
		Loan loanUpdated = loanService.save(loan);
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}

	@DeleteMapping("/users/{customerId}/loans/{id}")
	public ResponseEntity<Void> deleteloan(@PathVariable int customerId, @PathVariable long id) {
		Loan loan = loanService.deleteById(id);

		if (loan != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}*/
}
