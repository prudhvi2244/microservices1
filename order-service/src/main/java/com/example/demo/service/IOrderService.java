package com.example.demo.service;


import com.example.demo.common.TransactionResponse;
import com.example.demo.model.Order;

public interface IOrderService {

	
	public TransactionResponse placeOrder(Order order);
	
}
