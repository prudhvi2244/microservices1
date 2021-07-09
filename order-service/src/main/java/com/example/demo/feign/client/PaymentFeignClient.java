package com.example.demo.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.common.Payment;

@FeignClient(name = "PAYMENT-SERVICE",url="http://65.2.124.185:9002/payment/makePayment")
public interface PaymentFeignClient {
	
	@PostMapping
	public Payment makePayment(Payment payment);

}
