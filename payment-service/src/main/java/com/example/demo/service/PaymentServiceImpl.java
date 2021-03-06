package com.example.demo.service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repo.PaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository prepo;

	@Override
	public Payment makePayment(Payment payment) {
		
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(getPaymentStatus());
		payment.setTransactionDate(new Date());

		return prepo.save(payment);
	}
	
	public String getPaymentStatus()
	{
		return new Random().nextBoolean()?"Transaction Success":"Transaction Failed";
	}
	

}
