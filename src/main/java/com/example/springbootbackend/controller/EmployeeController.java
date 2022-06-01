package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees;

    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        return ResponseEntity.ok(employeeService.getEmployeeById (id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        List<Employee>allEmployee = employeeService.findAllEmployee();
        return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDetails));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable long id ){

        employeeService.deleteById(id);

    }


}