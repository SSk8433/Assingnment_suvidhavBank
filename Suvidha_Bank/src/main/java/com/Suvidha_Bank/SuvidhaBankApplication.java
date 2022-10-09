package com.Suvidha_Bank;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Suvidha_Bank.Repository.LoanRepository;
import com.Suvidha_Bank.Service.EmployeeService;
import com.Suvidha_Bank.entity.Collateral;
import com.Suvidha_Bank.entity.Customer;
import com.Suvidha_Bank.entity.Employee;
import com.Suvidha_Bank.entity.Loan;

@SpringBootApplication
public class SuvidhaBankApplication {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LoanRepository loanRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuvidhaBankApplication.class, args);
	}
	
//	@Bean
	public void initialize() {
		Customer c1=new Customer();
		c1.setCustomerIdentity("12345");
		c1.setCustomerName("Khalil");
		c1.setCustomerAddress("Mumbai");
		c1.setEmailId("khalil@123");
		c1.setAnnualIncome(100000.0);
		c1.setIncomeTaxReurnAttached(true);
		
		Loan l1=new Loan();
		l1.setLoanId("1001");
		l1.setLoanType("Buying House");
		l1.setLoanAmount(200000.0);
		l1.setInterestRate(4000.0);
		l1.setPeriod(3.0);
		l1.setRemarks("Well Cooperated");
		l1.setCustomer(c1);
		
		
		
		
		for(int i=110;i<120;i++) {
			Employee e=new Employee();
			e.setEmployeeId(""+i);
			e.setEmployeeName("Employee"+(i-100));
			this.employeeService.addEmployee(e);
		}
		
		Collateral co=new Collateral();
		co.setCollateralId("2001");
		co.setCollateralType("Vehicle");
//		co.setLoan(l1);
		
		Collateral co1=new Collateral();
		co1.setCollateralId("2002");
		co1.setCollateralType("Fixed Deposit");
//		co1.setLoan(l1;
		
		List<Collateral> list=Arrays.asList(co,co1);
		
//		l1.setCollaterals(list);
//     	l1.setEmployee(e);
     	
     	this.loanRepository.save(l1);
	}

}

