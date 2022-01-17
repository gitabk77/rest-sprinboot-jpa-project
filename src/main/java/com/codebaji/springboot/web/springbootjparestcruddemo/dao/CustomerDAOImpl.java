package com.codebaji.springboot.web.springbootjparestcruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codebaji.springboot.web.springbootjparestcruddemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// define field for entitymanager
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		
		// create a query
		Query theQuery = entityManager.createQuery("from Customer");
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public Customer findById(int theId) {

		// get the customer
		Customer theCustomer = entityManager.find(Customer.class, theId);
		
		// return the customer
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {

		Customer newCustomer = entityManager.merge(theCustomer);
		
		theCustomer.setId(newCustomer.getId());
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}
}
