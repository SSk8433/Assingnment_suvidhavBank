package com.Suvidha_Bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shubham_suvidha_customer")
public class Customer {
	
	
	@Id
	private String customerIdentity;
	private String customerName;
	private String customerAddress;
	private String emailId;
	private double annualIncome;
	private boolean incomeTaxReurnAttached;
	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private Loan loan;
	@Override
	public String toString() {
		return "Customer [customerIdentity=" + customerIdentity + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", emailId=" + emailId + ", annualIncome=" + annualIncome
				+ ", incomeTaxReurnAttached=" + incomeTaxReurnAttached + "]";
	}
	

}
