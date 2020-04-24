package com.javalearning.spring_bean_annotation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalearning.spring_bean_annotation.components.IBank;

@Service("bankService")
public class BankServiceImp implements IBankService {

	private List<IBank> banks;
	
	public BankServiceImp() {
		System.out.println(" -> bankService bean in created in BankServiceImp");
	}
	
	
	@Override
	public List<IBank> getAvailableBanks() {
		return banks;
	}
	
	/*
	 * This function will be called automatically, and its input parameters "List<IBank> list"
	 * is collected from beans in IoC Container.
	 * In this case, we have 3 beans "IBank" in this application from:
	 * + ACBBank from components package with @Componenet annotation
	 * + VNBank from components package with @Componenet annotation
	 * + getGreatACBBank from SpringConfiguration class
	 */
	@Autowired
	public void initBankFromAvailableBean(List<IBank> list) {
		banks = list;
	}
	
	
	/*
	 * This function will be called automatically, the bean which is same name with parameter will be fit
	 * In this case, we have 3 beans ACBBank, VNBank, getGreatACBBank in memory
	 * So, VNBank bean is used to set for this parameter
	 * If you change VNBank variable name to another name, a error will be appear
	 */
	@Autowired
	public void showBank(IBank VNBank) {
		System.out.println(VNBank);
	}

}
