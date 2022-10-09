package com.Suvidha_Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Suvidha_Bank.Repository.CollateralRepository;
import com.Suvidha_Bank.Repository.EmployeeRepository;
import com.Suvidha_Bank.Service.CustomerService;
import com.Suvidha_Bank.Service.LoanService;
import com.Suvidha_Bank.dto.Loandto;
import com.Suvidha_Bank.entity.Collateral;
import com.Suvidha_Bank.entity.Customer;
import com.Suvidha_Bank.entity.Loan;

@RestController
public class CustomerController {
	
	        
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CollateralRepository collateralRepository;
	
	@Autowired
	private LoanService loanService;
	



	
	@GetMapping("/customers")
	public String home() {
		return "home";
	}
	
	@GetMapping("/customer/{id}")
	public Customer CustomerById(@PathVariable String id)
	{
		return this.customerService.findCustomerById(id);
	}
	
	@PostMapping("/customer")
	public boolean addCustomer(@RequestBody Customer customer) {
		return this.customerService.insertCustomer(customer);
	}
	@PostMapping("/loan")
	public Loan applyForLoan(@RequestBody Loandto loandto) throws Exception 
	{	
		
		System.out.println("Calling loan method from controller");

		return this.loanService.applyForLoan(loandto.getType(),loandto.getAmount(),loandto.getPeriod(),loandto.getIdentity());

	}
	@PostMapping("/collat/{cid}")
	public boolean addCollat(@RequestBody Collateral collateral,@PathVariable String cid) {
		this.collateralRepository.save(collateral);
		return this.loanService.updateLoan(cid);
		
	}
	
	

}
