package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Payments 
{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
	private int  payment_id;
	private int  booking_id;
	private int transaction_id;
	
	@OneToOne
	@JoinColumn(name="transactions")
	private Transactions transactions;
	
	
	public Payments(){}
	

	public Payments(int payment_id, int booking_id, int transcation_id, Transactions transactions, int transaction_id) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.transaction_id = transaction_id;
		this.transactions = transactions;
	}


	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public Transactions getTransactions() {
		return transactions;
	}


	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}


	@Override
	public String toString() {
		return "Payments [payment_id=" + payment_id + ", booking_id=" + booking_id + ", transcation_id="
				+ transaction_id + ", transactions=" + transactions + "]";
	}


	

}


