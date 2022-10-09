package com.Suvidha_Bank.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Suvidha_Bank.entity.Customer;

public interface CustomerRepository extends CrudRepository< Customer, String> {

}
