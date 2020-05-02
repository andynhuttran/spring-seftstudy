package com.javalearning.rest.dao;

import java.util.List;
import java.util.UUID;

import com.javalearning.rest.model.Bank;

public interface BankDAO {

	int addBank(UUID id, Bank bank) throws Exception;
	
	List<Bank> getBanks(int top) throws Exception;
	
	//default function in interface, it is a new enhancement in Java 10
	default int addBank(Bank bank) throws Exception {		
		UUID id = UUID.randomUUID();		
		addBank(id, bank);		
		return 1;
	}
	
}
