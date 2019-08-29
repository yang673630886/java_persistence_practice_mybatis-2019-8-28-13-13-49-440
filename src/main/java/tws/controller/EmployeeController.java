package tws.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.mapper.EmployeeMapper;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employeeMapper.createEmployee(employee);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> selectEmployees() {
		return employeeMapper.selectEmployees();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee selectOneEmployee(@PathVariable int id) {
		return employeeMapper.selectOneEmployee(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delectEmployee(@PathVariable int id) {
		employeeMapper.deleteEmployee(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employeeMapper.updateEmployee(id, employee);
	}

}
