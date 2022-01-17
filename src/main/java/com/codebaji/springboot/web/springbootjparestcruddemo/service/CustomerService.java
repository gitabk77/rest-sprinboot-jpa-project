package com.codebaji.springboot.web.springbootjparestcruddemo.service;

import java.util.List;

import com.codebaji.springboot.web.springbootjparestcruddemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
}
