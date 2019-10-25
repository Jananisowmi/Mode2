package com.janani.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janani.model.Employee;
@Repository
public interface EmployeeInterface extends CrudRepository<Employee, Integer> {

}
