package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.response.LoanSchedule;
import com.example.demo.entity.Schedule;
import com.example.demo.service.LoanService;
import com.example.demo.service.ScheduleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/schedule/{id}")
	public LoanSchedule getSchedule( @PathVariable long id) {
		System.out.println("get schedule called");
		LoanSchedule calculateSchedule = scheduleService.calculateSchedule(id);
		return calculateSchedule;
	}


@PostMapping("/schedule")
	public ResponseEntity<?> updateSchedule(@RequestBody Schedule loan) {
		return null;
	}
	


}
