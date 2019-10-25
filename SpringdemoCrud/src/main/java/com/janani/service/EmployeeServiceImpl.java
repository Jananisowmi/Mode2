package com.janani.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janani.model.Employee;
import com.janani.repository.EmployeeInterface;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeInterface emprepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> lst=(List<Employee>) emprepository.findAll();
		if(lst.size()>0) {
			return lst;
			
		}else {
			return new ArrayList<Employee>();
		}
		
	
		
	}

	@Override
	public String addEmployee(String empStr) {
		List<Employee> lst=new ArrayList<Employee>();
		JSONArray jsonObject = (JSONArray)JSONValue.parse(empStr);
		Employee emp=new Employee();
		for(int i=0;i<jsonObject.size();i++){
		 JSONObject a= (JSONObject) jsonObject.get(i);
		 long id = (long) a.get("id");
		 emp.setId((int)id);
		 String name = (String) a.get("name");  
		 emp.setName(name);
		 double salary = (long) a.get("salary");
		 emp.setSalary(salary);
		}
		 Employee e=emprepository.save(emp);
		 if(e != null) {
		 return "Employee Successfully Created";
		 }
		 else {
		 return "Not Created";
		 }
 
		}

		
	
		

	@Override
	public String deleteEmployee(int id) {
		emprepository.deleteById(id);
		return "Deleted Successfully";
		}
		
	

	@Override
	public String updateEmployee(String empStr) {
		JSONArray jsonObject = (JSONArray)JSONValue.parse(empStr);
		Employee emp=new Employee();
		for(int i=0;i<jsonObject.size();i++){
		 JSONObject a= (JSONObject) jsonObject.get(i);
		 long id = (long) a.get("id");
		 emp.setId((int)id);
		 String name = (String) a.get("name");  
		 emp.setName(name);
		 double salary = (long) a.get("salary");
		 emp.setSalary(salary);
		}
		 Employee e=emprepository.save(emp);
		 return "Employee Successfully Updated";

		
		
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
	return emprepository.findById(id);
	}
		
	

	@Override
	
		public String addEmployees(String empStr) {
			JSONArray jsonArray = (JSONArray)JSONValue.parse(empStr);
			List<Employee> lst=new ArrayList<Employee>();
			for(int i=0;i<jsonArray.size();i++){
			Employee emp=new Employee();
			 JSONObject a= (JSONObject) jsonArray.get(i);
			 long id = (long) a.get("id");
			 emp.setId((int)id);
			 String name = (String) a.get("name");  
			 emp.setName(name);
			 double salary = (long) a.get("salary");
			 emp.setSalary(salary);
			 lst.add(emp);
			}
			 List<Employee> e=(List<Employee>)emprepository.saveAll(lst);
			 if(e != null) {
			 return "Employee Successfully Created";
			 }
			 else {
			 return "Not Created";
			 }
			}


		
		

	@Override
	public String deleteEmployees(String empStr) {
		JSONArray jsonArray = (JSONArray)JSONValue.parse(empStr);
		List<Employee> lst=new ArrayList<Employee>();
		for(int i=0;i<jsonArray.size();i++){
		Employee emp=new Employee();
		 JSONObject a= (JSONObject) jsonArray.get(i);
		 long id = (long) a.get("id");
		 emp.setId((int)id);
		 String name = (String) a.get("name");  
		 emp.setName(name);
		 double salary = (long) a.get("salary");
		 emp.setSalary(salary);
		 lst.add(emp);
		}
		 emprepository.deleteAll(lst);
		return  "Employees Successfully Deleted";
		}
	

	@Override
	public String updateEmployees(String empStr) {
		JSONArray jsonArray = (JSONArray)JSONValue.parse(empStr);
		List<Employee> lst=new ArrayList<Employee>();
		for(int i=0;i<jsonArray.size();i++){
		Employee emp=new Employee();
		 JSONObject a= (JSONObject) jsonArray.get(i);
		 long id = (long) a.get("id");
		 emp.setId((int)id);
		 String name = (String) a.get("name");  
		 emp.setName(name);
		 double salary = (long) a.get("salary");
		 emp.setSalary(salary);
		 lst.add(emp);
		}
		 List<Employee> e=(List<Employee>)emprepository.saveAll(lst);
		 return "Employee Successfully Updated";
		}

		
		
	

	@Override
	public void getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		
	}
}

	
