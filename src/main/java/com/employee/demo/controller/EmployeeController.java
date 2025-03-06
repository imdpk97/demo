package com.employee.demo.controller;

import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    //localhost:8080/api/allEmployees
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
       return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmpById/{id}")
    public Optional<Employee> getEmpById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/createNewEmployee")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return (employeeService.addNewEmployee(employee));
    }

    

    @PutMapping("/updateEmployee/{id}")
    public Employee updatEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return (employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public void deleteById(@PathVariable Integer id){
         employeeService.deleteEmployeeById(id);
    }

}
