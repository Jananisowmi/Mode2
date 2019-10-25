package com.janani.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janani.model.Employee;
import com.janani.service.EmployeeService;
import com.janani.service.EmployeeServiceImpl;

@RestController

@RequestMapping(value="/Employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl empService;
	@RequestMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> lst=empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(lst,new HttpHeaders(),HttpStatus.OK);
		
	}

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody String empStr)
	{
		return new ResponseEntity<String>(empService.addEmployee(empStr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<String> addEmployees(@RequestBody String empStr) {
	return new ResponseEntity<String>(empService.addEmployees(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
	return new ResponseEntity<String>(empService.deleteEmployee(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/deleteAll")
	public ResponseEntity<String> deleteEmployees(@RequestBody String empStr) {
	return new ResponseEntity<String>(empService.deleteEmployees(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody String empStr) {
	return new ResponseEntity<String>(empService.updateEmployee(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
    @PostMapping("/updateAll")
    public ResponseEntity<String> updateEmployees(@RequestBody String empStr) {
    	return new ResponseEntity<String>(empService.updateEmployees(empStr),new HttpHeaders(),HttpStatus.OK);
    }

	@PostMapping("/{id}/get")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable int id) {
	return new ResponseEntity<Optional<Employee>>(empService.getEmployee(id), new HttpHeaders(), HttpStatus.OK);
	}


}


