package com.learnings.demo.payroll;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;
	
   EmployeeController(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employees")
    List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	 Employee getEmployee(@PathVariable Long id){
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping("/employees")
	 Employee addEmployee(@RequestBody Employee employee ) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping("/employees/{id}")
	Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		return employeeRepository.findById(id).map(emp -> {
			emp.setName(employee.getName());
		    emp.setRole(employee.getRole());
		    return employeeRepository.save(emp);
		}
		).orElseGet(()->{
			employee.setId(id);
			return addEmployee(employee);
		});
	}
	
	  @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    employeeRepository.deleteById(id);
	  }
	 

}
