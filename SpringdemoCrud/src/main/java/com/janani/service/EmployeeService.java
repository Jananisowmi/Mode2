package com.janani.service;

import java.util.List;
import java.util.Optional;

import com.janani.model.Employee;

public interface EmployeeService {
	
  public List<Employee> getAllEmployees() ;
	
  public String addEmployee(String empStr) ;
  public String addEmployees(String empStr) ;
  
  
  public String deleteEmployee(int id);
  public String deleteEmployees(String empStr);
  
  public String updateEmployee(String empStr);
  public String updateEmployees(String empStr);
  
  public Optional<Employee> getEmployee(int id) ;
  public void getEmployeesByName(String name);
  
  
  
  
 
  
  


  
  
  
	

}
