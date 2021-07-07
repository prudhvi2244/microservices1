package com.example.demo.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class Payment {

	private Integer pid;
	private String transactionId;
	private String paymentStatus;
	private Date transactionDate;
	private Double amount;
	private Integer order_id;

}
