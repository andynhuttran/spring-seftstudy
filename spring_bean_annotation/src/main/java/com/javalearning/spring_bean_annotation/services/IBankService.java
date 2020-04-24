package com.javalearning.spring_bean_annotation.services;

import java.util.List;

import com.javalearning.spring_bean_annotation.components.IBank;

public interface IBankService {
	public List<IBank> getAvailableBanks();
}
