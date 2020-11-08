package com.example.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

}
