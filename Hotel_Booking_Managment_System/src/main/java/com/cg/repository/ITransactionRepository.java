package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Transactions;

@Repository
public interface ITransactionRepository extends JpaRepository<Transactions, Integer>  {
	
	

}
