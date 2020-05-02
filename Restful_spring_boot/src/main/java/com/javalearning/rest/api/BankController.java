package com.javalearning.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javalearning.rest.exception.BankException;
import com.javalearning.rest.model.Bank;
import com.javalearning.rest.service.BankService;


@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

	private BankService bankService;
	
	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}
	
	@GetMapping
	public List<Bank> getBanks(@RequestParam(name = "top", required = false, defaultValue = "0") int top){
		System.out.println(top);
		
		if (top <= 0) { //handle exception
			String msg = String.format("top = %d is not accepted, it should be bigger than 0");
			throw new BankException(msg);
		}
		
		List<Bank> banks = bankService.getBanks(top);
		return banks;
	}
	
}
