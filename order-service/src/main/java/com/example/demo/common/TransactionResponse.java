package com.example.demo.common;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionResponse {
	
	private Integer order_id;
	private Integer pid;
	private String pstatus;
	private String transaction_id;
	private Date transactionDate;
	private Double amount;
	private String pname;
	private Integer quantity;

}
