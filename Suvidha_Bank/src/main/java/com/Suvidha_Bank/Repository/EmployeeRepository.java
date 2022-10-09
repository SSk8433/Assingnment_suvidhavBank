package com.Suvidha_Bank.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Suvidha_Bank.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
