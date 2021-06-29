package com.example.MyWeb.UserService.Stocks;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@Autowired
	StockService service;
	
	@GetMapping(path="/getStock/{Company}")
	public ResponseEntity<Object> getStocks(@PathVariable String Company){
		
		return service.getStocks(Company);
	}
	@PostMapping(path="/createStock")
	public ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock){
		
		return service.createStock(stock);
	}
	@PutMapping(path="/updateStock")
	public ResponseEntity<Object> update(@Valid @RequestBody Stock stock){
		
		return service.updateStock(stock);
	}
	@DeleteMapping(path="/deleteStock/{company}")
	public ResponseEntity<Object> delete(@PathVariable String company ){
		
		return service.delete(company);
	}
	
	@GetMapping(path="/getAllStocks")
	public List<Stock> getAll(){
		
		return  service.getAll();
	}
}
