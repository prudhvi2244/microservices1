package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.TransactionResponse;
import com.example.demo.model.Order;
import com.example.demo.service.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private IOrderService oservice;
	
	/*
	 *  http://localhost:9001/order/placeOrder
	 	{
	      "pname":"Samsung",
	      "quantity":2
	 	}
	 */
	
	@PostMapping(value = "/placeOrder")
	public ResponseEntity<TransactionResponse> saveOrder(@RequestBody Order order)
	{
		TransactionResponse tresponse=oservice.placeOrder(order);
		return new ResponseEntity<TransactionResponse>(tresponse,HttpStatus.CREATED);
	}
	
}
