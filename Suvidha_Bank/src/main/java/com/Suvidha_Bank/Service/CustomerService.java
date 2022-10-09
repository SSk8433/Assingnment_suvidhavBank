package com.Suvidha_Bank.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Suvidha_Bank.Repository.CustomerRepository;
import com.Suvidha_Bank.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository ;
	
	public Customer findCustomerById(String  customerIdentity ) {
		Optional<Customer> optc = this.customerRepository.findById(customerIdentity);
		return optc.orElseThrow(() -> new EntityNotFoundException("Coustomer not found"));	
		
	}
	
	public boolean insertCustomer(Customer customer) {
		if(!this.customerRepository.existsById(customer.getCustomerIdentity())) {
			this.customerRepository.save(customer);
			return true ;
		}
		return false ;
	}
	

}
