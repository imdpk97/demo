package com.employee.demo.controller;

import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    //recom. sonarqube useing Constructor injection instead of @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    //localhost:8080/api/allEmployees
    @GetMapping
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee()); // Needed for form binding
        return "index";
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmpById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String addNewEmployee(@ModelAttribute Employee employee){
         employeeService.addNewEmployee(employee);
        return "redirect:/employees";
    }

    

    @PutMapping("/{id}")
    public Employee updatEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return (employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
         employeeService.deleteEmployeeById(id);
    }

}
