package com.javalearning.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.javalearning.rest.model.Bank;


@Repository("fakeDAO")
public class FakeBankDAO implements BankDAO {

	private List<Bank> banks = new ArrayList<Bank>();
	
	public FakeBankDAO() {
		banks.add(new Bank("Cole"));
		banks.add(new Bank("Andy"));
		banks.add(new Bank("Nhut"));
	}
	
	@Override
	public int addBank(UUID id, Bank bank) throws Exception {
		bank.setId(id);
		banks.add(bank);		
		return 1;
	}

	@Override
	public List<Bank> getBanks(int top) throws Exception {
		if (top <= 0 || top >= banks.size()) { //return all banks
			return banks;
		}
		return banks.subList(0, top);
	}

}
