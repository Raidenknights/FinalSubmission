package com.example.MyWeb.UserService.Stocks;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyWeb.UserService.UserModel.UserNotFound;
import com.example.MyWeb.UserService.UserModel.WrongCredentials;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepo;
	
	
	public ResponseEntity<Object> updateStock(Stock stock) {
		
		stockRepo.deleteByCompany(stock.getCompany());
		stockRepo.save(stock);
		 
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	
	public ResponseEntity<Object> getStocks(String Company) {
		Stock stk = stockRepo.findByCompany(Company);
		System.out.println(stk);
		if(stk==null) {
			throw new UserNotFound("No company with the given name");
		}
		return new ResponseEntity(stk,HttpStatus.FOUND);
	}

	
	public ResponseEntity<Object> createStock(@Valid Stock stock) {
		
		stockRepo.save(stock);
		return new ResponseEntity(stock,HttpStatus.CREATED);
	}

	public ResponseEntity<Object> delete(String company) {
		Stock stk = stockRepo.findByCompany(company);
		if(stk==null) {
			throw new WrongCredentials("Company do not exist");
		}
		stockRepo.deleteByCompany(company);
		
		return new ResponseEntity(HttpStatus.OK);
	}

	public List<Stock> getAll() {
		
		return stockRepo.findAll();
	}

}
