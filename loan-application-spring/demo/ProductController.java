package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;
 
@RestController
public class ProductController {
 
    @Autowired
    private ProductService service;
	
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }
	
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }
    
   /* @PostMapping(path="/products") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
        , @RequestParam float price, @RequestParam float ratings) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request

      Product n = new Product();
      n.setName(name);
      n.setPrice(price);
      n.setRate(ratings);
      service.save(n);
      return "Saved";
    }*/
    
    
}
