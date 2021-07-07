package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.common.Payment;
import com.example.demo.common.TransactionResponse;
import com.example.demo.model.Order;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${payment.url}")
	private String url;
	
	@Value("${product.price}")
	private String price;


	@Override
	public TransactionResponse placeOrder(Order order) {
		
		Double finalPrice = order.getQuantity() * Double.parseDouble(price);
		order.setPrice(finalPrice);
		Order savedOrder=orepo.save(order);
		
		Payment payment = new Payment();
		payment.setAmount(finalPrice);
		payment.setOrder_id(savedOrder.getOrder_id());
		Payment savedPayment = restTemplate.postForObject(url, payment,
				Payment.class);

		TransactionResponse response = new TransactionResponse();
		response.setAmount(finalPrice);
		response.setOrder_id(order.getOrder_id());
		response.setPid(savedPayment.getPid());
		response.setPstatus(savedPayment.getPaymentStatus());
		response.setTransaction_id(savedPayment.getTransactionId());
		response.setTransactionDate(savedPayment.getTransactionDate());
		response.setPname(savedOrder.getPname());
		response.setQuantity(savedOrder.getQuantity());
		return response;
	}

}
