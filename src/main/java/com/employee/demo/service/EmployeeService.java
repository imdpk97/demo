package com.employee.demo.service;

import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        List<Employee> allEmployeesList = employeeRepository.findAll();
       return allEmployeesList;
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public Employee addNewEmployee(Employee employee){
        Employee employee1= new Employee();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setSalary(employee.getSalary());
        employeeRepository.save(employee1);
        return employee1;
    }

    public Employee updateEmployee(Integer id, Employee employee){
        // Get + post = put (update)
        Employee employee1 = employeeRepository.getById(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setSalary(employee.getSalary());
        employeeRepository.save(employee1);
        return employee1;
    }

    public void deleteEmployeeById(Integer id){
       employeeRepository.deleteById(id);
    }

}
