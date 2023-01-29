package com.cg.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	private double amount;
	
	@OneToOne(mappedBy="transactions",cascade = CascadeType.ALL)
	private Payments payment;
	
	

	public Transactions() {
	}

	public Transactions(int transaction_id, double amount,Payments payment) 
	{
		super();
		this.payment=payment;
		this.transaction_id = transaction_id;
		this.amount = amount;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", amount=" + amount + ", payment=" + payment + "]";
	}
     
	

}
