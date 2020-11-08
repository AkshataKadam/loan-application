package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "helloooo!!!!!!!!!!!";
	}
	
		@GetMapping(path="/hello-bean/{mess}")
		public Hello helloWorldBean(@PathVariable String mess) {
			//throw new RuntimeException("Errorrrrrrrrrr has occurred!!!");
			return new Hello(String.format("helloo beannnnn %s",mess));
		}

}
