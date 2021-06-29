package com.example.MyWeb.UserService.Stocks;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface StockService {

	 ResponseEntity<Object> updateStock(Stock stock);
	 ResponseEntity<Object> getStocks(String Company);
	 ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock);
	 ResponseEntity<Object> delete(String company );
	 List<Stock> getAll();
}
