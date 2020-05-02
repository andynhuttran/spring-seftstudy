package com.javalearning.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javalearning.rest.dao.BankDAO;
import com.javalearning.rest.exception.BankException;
import com.javalearning.rest.model.Bank;

@Service
public class BankService {

	
	private BankDAO bankDAO;
	
	@Autowired()
	public BankService(@Qualifier("fakeDAO") BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	public int addBank(Bank bank) {
		try {
			return bankDAO.addBank(bank);
		}
		catch (Exception e) {
			//TODO handle exception
		}
		return 0;
	}
	
	
	public List<Bank> getBanks(int top) throws BankException{
		try {
			return bankDAO.getBanks(top);
		} catch (Exception e) {
			throw new BankException(e.getMessage());
		}
	}
	
	
}








