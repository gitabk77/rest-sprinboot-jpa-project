package com.codebaji.springboot.web.springbootjparestcruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebaji.springboot.web.springbootjparestcruddemo.dao.CustomerDAO;
import com.codebaji.springboot.web.springbootjparestcruddemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> findAll() {

		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {

		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {

		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		customerDAO.deleteById(theId);
	}
}
